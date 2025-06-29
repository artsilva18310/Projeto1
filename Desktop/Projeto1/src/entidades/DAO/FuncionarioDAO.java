/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Funcionario;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 *
 */
public class FuncionarioDAO {

    ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public void salvar(Funcionario f) throws SQLException {

        String sql = ""
                + "INSERT INTO Funcionario (nome, cargo) VALUES ("
                + "'" + f.getNome() + "',"
                + "'" + f.getCargo() + "' "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);

    }

   public ArrayList<Funcionario> recuperarTodos(String criterio) throws SQLException {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    String sql = "SELECT * FROM Funcionario WHERE nome ILIKE '%" + criterio + "%'";

    resultadoQ = ConexaoBD.executeQuery(sql);

    while (resultadoQ.next()) {
        Funcionario funcionario = new Funcionario();

        funcionario.setIdfuncionario(resultadoQ.getInt("idfuncionario"));
        funcionario.setNome(resultadoQ.getString("nome"));
        funcionario.setCargo(resultadoQ.getString("cargo"));

        funcionarios.add(funcionario); // Adiciona na lista correta
    }

    return funcionarios;
}


    public ArrayList<Funcionario> recuperarTodos() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList();

        String sql = ""
                + "SELECT * FROM Funcionario ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Funcionario funcionario = new Funcionario();

            funcionario.setIdfuncionario(resultadoQ.getInt("idfuncionario"));
            funcionario.setNome(resultadoQ.getString("nome"));
            funcionario.setCargo(resultadoQ.getString("cargo"));

            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    public void editar(Funcionario f) throws SQLException {
        String sql = ""
                + "UPDATE Funcionario "
                + "SET "
                + "nome = '" + f.getNome() + "',"
                + "cargo = '" + f.getCargo() + "'"
                + "WHERE idfuncionario = " + f.getIdfuncionario();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public Funcionario recuperar(int idfuncionario) throws SQLException {
        Funcionario funcionario = null;
        String sql = ""
                + "SELECT * FROM Funcionario WHERE idfuncionario = " + idfuncionario;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            funcionario = new Funcionario();

            funcionario.setIdfuncionario(resultadoQ.getInt("idfuncionario"));
            funcionario.setNome(resultadoQ.getString("nome"));
            funcionario.setCargo(resultadoQ.getString("cargo"));

        }

        return funcionario;
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM Funcionario WHERE idfuncionario = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
