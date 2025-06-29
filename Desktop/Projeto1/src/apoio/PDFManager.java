package apoio;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Gera um PDF A4 (retrato) em tabela monoespaçada. • Ordem das colunas, rótulos
 * do cabeçalho e larguras vêm do chamador.
 */
public class PDFManager {

    /**
     * @param objetos lista de Objetos a imprimir
     * @param caminho caminho de saída do PDF
     * @param fieldOrder nomes dos campos na ordem desejada
     * @param colWidths larguras (mesmo tamanho de fieldOrder)
     * @param headerLabels rótulos mostrados no cabeçalho (mesmo tamanho que
     * fieldOrder)
     */
    public static void gerar(List<?> objetos,
            String caminho,
            String[] fieldOrder,
            int[] colWidths,
            String[] headerLabels) throws IOException {

        // ===== validações básicas =====
        if (objetos == null || objetos.isEmpty()) {
            throw new IllegalArgumentException("Lista de objetos está vazia.");
        }
        int n = fieldOrder.length;
        if (colWidths.length != n || headerLabels.length != n) {
            throw new IllegalArgumentException(
                    "fieldOrder, colWidths e headerLabels devem ter o mesmo comprimento.");
        }

        // ===== mapa nome→Field para busca rápida =====
        Class<?> clazz = objetos.get(0).getClass();
        Map<String, Field> mapa = new HashMap<>();
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            mapa.put(f.getName(), f);
        }

        // ===== vetor Field[] na ordem pedida =====
        Field[] fields = Arrays.stream(fieldOrder)
                .map(nome -> {
                    Field fld = mapa.get(nome);
                    if (fld == null) {
                        throw new IllegalArgumentException(
                                "Campo \"" + nome + "\" não existe em "
                                + clazz.getSimpleName());
                    }
                    return fld;
                })
                .toArray(Field[]::new);

        // ===== PDF setup =====
        final PDRectangle pageSize = PDRectangle.A4;
        final int margin = 50;
        final float leading = 14.5f;
        final int fontSize = 10;
        final int pageH = (int) pageSize.getHeight();
        final int maxLines = (int) ((pageH - 2 * margin) / leading);
        final PDType1Font font = new PDType1Font(FontName.COURIER);

        // ===== cabeçalho & divisor =====
        String header = formatRow(headerLabels, colWidths);
        String divisor = "_".repeat(header.length());

        try (PDDocument doc = new PDDocument()) {

            PDPage page = new PDPage(pageSize);
            doc.addPage(page);
            PDPageContentStream out = startStream(doc, page, font,
                    fontSize, margin,
                    pageH, leading);

            int line = 0;
            writeLine(out, header);
            line++;
            writeLine(out, divisor);
            line++;

            // ===== percorre objetos =====
            for (Object obj : objetos) {

                // valores na ordem correta
                List<String> valores = new ArrayList<>();
                for (Field f : fields) {
                    Object v = f.get(obj);
                    valores.add(v == null ? "" : v.toString());
                }

                // divide cada coluna em possíveis sublinhas
                List<String[]> partes = new ArrayList<>();
                for (int c = 0; c < valores.size(); c++) {
                    partes.add(wrap(valores.get(c), colWidths[c]));
                }

                int linhasNec = partes.stream().mapToInt(a -> a.length).max().orElse(1);

                for (int l = 0; l < linhasNec; l++) {

                    StringBuilder sb = new StringBuilder();
                    for (int c = 0; c < valores.size(); c++) {
                        String txt = l < partes.get(c).length ? partes.get(c)[l] : "";
                        sb.append(fix(txt, colWidths[c])).append(" | ");
                    }
                    writeLine(out, sb.toString());
                    line++;

                    if (line >= maxLines - 2) {
                        out = novaPagina(doc, pageSize, font,
                                fontSize, margin, pageH,
                                leading, header, divisor);
                        line = 2;
                    }
                }

                // linha divisória após o registro
                writeLine(out, divisor);
                line++;

                if (line >= maxLines - 2) {
                    out = novaPagina(doc, pageSize, font,
                            fontSize, margin, pageH,
                            leading, header, divisor);
                    line = 2;
                }
            }

            out.endText();
            out.close();
            doc.save(new File(caminho));

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar atributos dos objetos", e);
        }
    }

    // ---------- auxiliares internos ----------
    private static String fix(String txt, int w) {
        return txt.length() > w ? txt.substring(0, w)
                : String.format("%-" + w + "s", txt);
    }

    private static String formatRow(String[] vals, int[] widths) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            sb.append(fix(vals[i], widths[i])).append(" | ");
        }
        return sb.toString();
    }

    /**
     * Quebra `txt` em linhas de até `w` caracteres. – Mantém palavras inteiras
     * sempre que couberem. – Para palavras sem espaço (e-mails, CPF etc.)
     * maiores que `w`, corta em blocos de `w` sem criar linha vazia.
     */
    private static String[] wrap(String txt, int w) {
        List<String> linhas = new ArrayList<>();
        StringBuilder linha = new StringBuilder();

        for (String palavra : txt.split(" ")) {

            // se a palavra sozinha já é maior que a coluna, corta em blocos
            if (palavra.length() > w) {
                // descarrega o que já havia na linha
                if (linha.length() > 0) {
                    linhas.add(linha.toString());
                    linha.setLength(0);
                }
                // fatia a palavra longa
                for (int i = 0; i < palavra.length(); i += w) {
                    int fim = Math.min(i + w, palavra.length());
                    linhas.add(palavra.substring(i, fim));
                }
                continue;
            }

            // palavra cabe na linha atual?
            if (linha.length() + palavra.length() + (linha.length() == 0 ? 0 : 1) <= w) {
                if (linha.length() > 0) {
                    linha.append(" ");
                }
                linha.append(palavra);
            } else { // não cabe → fecha a linha e começa outra
                linhas.add(linha.toString());
                linha = new StringBuilder(palavra);
            }
        }

        if (linha.length() > 0) {
            linhas.add(linha.toString());
        }
        return linhas.toArray(new String[0]);
    }

    private static PDPageContentStream startStream(PDDocument doc, PDPage p,
            PDFont f, int size,
            int margin, int pageH,
            float leading) throws IOException {
        PDPageContentStream s = new PDPageContentStream(doc, p);
        s.setFont(f, size);
        s.beginText();
        s.setLeading(leading);
        s.newLineAtOffset(margin, pageH - margin);
        return s;
    }

    private static PDPageContentStream novaPagina(PDDocument doc,
            PDRectangle pageSize,
            PDFont font, int fontSize,
            int margin, int pageH,
            float leading,
            String header,
            String divisor) throws IOException {
        PDPage p = new PDPage(pageSize);
        doc.addPage(p);
        PDPageContentStream s = startStream(doc, p, font, fontSize,
                margin, pageH, leading);
        writeLine(s, header);
        writeLine(s, divisor);
        return s;
    }

    private static void writeLine(PDPageContentStream s, String txt) throws IOException {
        s.showText(txt);
        s.newLine();
    }
}
