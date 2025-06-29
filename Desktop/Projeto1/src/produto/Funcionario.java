/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produto;
import telas.TelaPrincipal;
import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import telas.TelaLogin;
/**
 *
 * @author arthu
 */
public class Funcionario {
    
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        try {
            ConexaoBD.getInstance().getConnection();

            TelaLogin tl = new TelaLogin();
            tl.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!\nPor favor entre em contato com o suporte.");
        } finally {
            ConexaoBD.getInstance().shutdown();
        }

    }

}

