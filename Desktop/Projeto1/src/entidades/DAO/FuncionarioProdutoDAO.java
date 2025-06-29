/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.FuncionarioProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioProdutoDAO {

    private ResultSet resultadoQ = null;

    /**
     * Insere uma nova relação entre funcionário e produto.
     */
    public void inserir(FuncionarioProduto fp) throws SQLException {
        String sql = "INSERT INTO funcionario_produto (idfuncionario, idproduto) VALUES ("
                   + fp.getIdFuncionario() + ", "
                   + fp.getIdProduto() + ")";
        
        System.out.println("SQL inserir: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    /**
     * Remove uma relação entre funcionário e produto.
     */
    public void remover(FuncionarioProduto fp) throws SQLException {
        String sql = "DELETE FROM funcionario_produto WHERE idfuncionario = "
                   + fp.getIdFuncionario() + " AND idproduto = " + fp.getIdProduto();
        
        System.out.println("SQL remover: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    /**
     * Recupera todos os produtos vinculados a um determinado funcionário.
     */
    public ArrayList<FuncionarioProduto> recuperarPorFuncionario(int idFuncionario) throws SQLException {
        ArrayList<FuncionarioProduto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionario_produto WHERE idfuncionario = " + idFuncionario;
        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            FuncionarioProduto fp = new FuncionarioProduto();
            fp.setIdFuncionario(resultadoQ.getInt("idfuncionario"));
            fp.setIdProduto(resultadoQ.getInt("idproduto"));
            lista.add(fp);
        }

        return lista;
    }

    /**
     * Recupera todos os funcionários vinculados a um determinado produto.
     */
    public ArrayList<FuncionarioProduto> recuperarPorProduto(int idProduto) throws SQLException {
        ArrayList<FuncionarioProduto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionario_produto WHERE idproduto = " + idProduto;
        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            FuncionarioProduto fp = new FuncionarioProduto();
            fp.setIdFuncionario(resultadoQ.getInt("idfuncionario"));
            fp.setIdProduto(resultadoQ.getInt("idproduto"));
            lista.add(fp);
        }

        return lista;
    }
    public ArrayList<FuncionarioProduto> recuperarTodos() throws SQLException {
    ArrayList<FuncionarioProduto> lista = new ArrayList<>();
    String sql = "SELECT * FROM funcionario_produto";
    resultadoQ = ConexaoBD.executeQuery(sql);

    while (resultadoQ.next()) {
        FuncionarioProduto fp = new FuncionarioProduto();
        fp.setIdFuncionario(resultadoQ.getInt("idfuncionario"));
        fp.setIdProduto(resultadoQ.getInt("idproduto"));
        lista.add(fp);
    }

    return lista;
}
}

