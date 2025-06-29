/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author arthur.silva3
 */
public class FileManager {
        /**
     * Salva uma linha de texto no arquivo informado. Se o arquivo não existir,
     * ele será criado. A linha é adicionada ao final do arquivo (modo append).
     *
     * @param conteudoLinha Linha de texto a ser salva
     * @param caminhoArquivo Caminho do arquivo onde será salva a linha
     */
    public static void adicionarLinhaNoArquivo(String conteudoLinha, String caminhoArquivo) {
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(caminhoArquivo, true));
            System.out.println("Salvando no arquivo: " + new File(caminhoArquivo).getAbsolutePath());
            escritor.write(conteudoLinha);      // Escreve o conteúdo no arquivo
            escritor.newLine();                 // Adiciona uma quebra de linha após escrever
        } catch (IOException erro) {
            System.err.println("Erro ao salvar linha no arquivo: " + erro.getMessage());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }

    /**
     * Lê todas as linhas de um arquivo e retorna como ArrayList de strings.
     *
     * @param caminhoArquivo Caminho do arquivo a ser lido
     * @return Lista de linhas lidas do arquivo
     */
    public static ArrayList<String> lerLinhasDoArquivo(String caminhoArquivo) {
        ArrayList<String> linhasLidas = new ArrayList();
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linhaAtual;
            while ((linhaAtual = leitor.readLine()) != null) {
                linhasLidas.add(linhaAtual);
            }
        } catch (IOException erro) {
            System.err.println("Erro ao ler o arquivo: " + erro.getMessage());
        } finally {
            try {
                if (leitor != null) {
                    leitor.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }

        return linhasLidas;
    }
}


