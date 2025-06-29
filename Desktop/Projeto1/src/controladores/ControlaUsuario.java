/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.UsuarioDAO;
import entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author mateus
 */
public class ControlaUsuario {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean validaLogin(String usuario, String senha) {
        try {
            Usuario u = usuarioDAO.validaLogin(usuario, senha);
            if (u != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }


  public boolean salvar(Usuario u) {
        try {
            usuarioDAO.salvar(u);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Usuario: " + ex.getMessage());
            return false;
        }
    }


 public boolean editar( Usuario u){
        try {
           usuarioDAO.editar(u);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar  Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean excluir(int id){
        try {
             usuarioDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Usuario: " + ex.getMessage());
            return false;
        }
    }
    
    public Usuario recuperar(int id){
        try {
             Usuario usuario =  usuarioDAO.recuperar(id);
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Usuario: " + ex.getMessage());
            return null;
        }
    }
    public Usuario recuperar(String u){
        try {
             Usuario usuario =  usuarioDAO.recuperar(u);
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Usuario: " + ex.getMessage());
            return null;
        }
    }


    public ArrayList<Usuario> recuperarTodos(){
        ArrayList<Usuario> vetorUsuario = null;
        try {
            vetorUsuario = usuarioDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Usuario: " + ex.getMessage());
        }
        return vetorUsuario;
}
}