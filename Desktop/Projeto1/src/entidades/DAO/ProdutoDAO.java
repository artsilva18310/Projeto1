/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Produto;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author mateus
 */
public class ProdutoDAO {

    ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public void salvar(Produto p) throws SQLException {
        String sql = ""
                + "INSERT INTO Produto (nome,tipo, peso, ingrediente,qtdestoque) VALUES ("
                + "'" + p.getNome() + "',"
                + "'" + p.getTipo() + "',"
                + "'" + p.getPeso() + "',"
                + "'" + p.getIngrediente() + "', "
                + "" + p.getQtdestoque() + " "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Produto> recuperarTodos() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList();

        String sql = ""
                + "SELECT * FROM Produto ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Produto produto = new Produto();

            produto.setId(resultadoQ.getInt("idproduto"));
            produto.setNome(resultadoQ.getString("nome"));
            produto.setTipo(resultadoQ.getString("tipo"));
            produto.setPeso(resultadoQ.getDouble("peso"));
            produto.setIngrediente(resultadoQ.getString("ingrediente"));
            produto.setQtdestoque(resultadoQ.getInt("qtdestoque"));

            produtos.add(produto);
        }

        return produtos;
    }

    public Produto recuperar(int idproduto) throws SQLException {
        Produto produto = null;
        String sql = ""
                + "SELECT * FROM Produto WHERE idproduto = " + idproduto;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            produto = new Produto();

            produto.setId(resultadoQ.getInt("idproduto"));
            produto.setNome(resultadoQ.getString("nome"));
            produto.setTipo(resultadoQ.getString("tipo"));
            produto.setPeso(resultadoQ.getInt("peso"));
            produto.setIngrediente(resultadoQ.getString("ingrediente"));
            produto.setQtdestoque(resultadoQ.getInt("qtdestoque"));
        }

        return produto;
    }

    public void editar(Produto p) throws SQLException {
        String sql = ""
                + "UPDATE Produto "
                + "SET "
                + "nome = '" + p.getNome() + "',"
                + "tipo = '" + p.getTipo() + "',"
                + "peso = '" + p.getPeso() + "',"
                + "ingrediente = '" + p.getIngrediente() + "', "
                + "qtdestoque = '" + p.getQtdestoque() + "' "
                + "WHERE idproduto = " + p.getId();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public void excluir(int idproduto) throws SQLException {
        String sql = ""
                + "DELETE FROM Produto WHERE idproduto = " + idproduto;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Produto> recuperarTodos(String criterio) throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM Produto";
        if (criterio != null && !criterio.trim().isEmpty()) {
            sql += " WHERE nome ILIKE '%" + criterio + "%'";
        }

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Produto produto = new Produto();
            produto.setId(resultadoQ.getInt("idproduto"));
            produto.setNome(resultadoQ.getString("nome"));
            produto.setTipo(resultadoQ.getString("tipo"));
            produto.setPeso(resultadoQ.getDouble("peso"));
            produto.setIngrediente(resultadoQ.getString("ingrediente"));
            produto.setQtdestoque(resultadoQ.getInt("qtdestoque"));
            produtos.add(produto);
        }

        return produtos;
    }

}
