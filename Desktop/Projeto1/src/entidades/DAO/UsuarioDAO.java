/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class UsuarioDAO {

    private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public Usuario validaLogin(String usuario, String senha) throws SQLException {
        Usuario u = null;
        String sql = ""
                + "SELECT * FROM usuario "
                + "WHERE usuario = '" + usuario + "' "
                + "AND senha = md5('" + senha + "')";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            u = new Usuario();
            u.setId(resultadoQ.getInt("id"));
            u.setUsuario(resultadoQ.getString("usuario"));
            u.setSenha(resultadoQ.getString("senha"));
            u.setPerfil(resultadoQ.getString("perfil"));

        }

        return u;
    }

    public ArrayList<Usuario> recuperarTodos() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList();

        String sql = ""
                + "SELECT * FROM Usuario ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Usuario usuario = new Usuario();

            usuario.setId(resultadoQ.getInt("id"));
            usuario.setUsuario(resultadoQ.getString("usuario"));
            usuario.setSenha(resultadoQ.getString("senha"));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    public Usuario recuperar(int id) throws SQLException {
        Usuario usuario = null;
        String sql = ""
                + "SELECT * FROM Usuario WHERE id = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            usuario = new Usuario();

            usuario.setId(resultadoQ.getInt("id"));
            usuario.setUsuario(resultadoQ.getString("usuario"));
            usuario.setSenha(resultadoQ.getString("senha"));
        }

        return usuario;
    }

    public Usuario recuperar(String u) throws SQLException {
        Usuario usuario = null;
        String sql = ""
                + "SELECT * FROM Usuario WHERE usuario = '" + u + "'";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            usuario = new Usuario();

            usuario.setId(resultadoQ.getInt("id"));
            usuario.setUsuario(resultadoQ.getString("usuario"));
            usuario.setSenha(resultadoQ.getString("senha"));
        }

        return usuario;
    }

    public void editar(Usuario u) throws SQLException {
        String sql = ""
                + "UPDATE Usuario SET "
                + "usuario = '" + u.getUsuario() + "', "
                + "senha = md5('" + u.getSenha() + "'), "
                + "perfil = '" + u.getPerfil() + "' "
                + "WHERE id = " + u.getId();

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM Usuario WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public void salvar(Usuario u) throws SQLException {

        String sql = ""
                + "INSERT INTO Usuario (usuario, senha, perfil) VALUES ("
                + "'" + u.getUsuario() + "',"
                + "md5('" + u.getSenha() + "'),"
                + "'" + u.getPerfil() + "'"
                + ")";
        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);

    }
}
