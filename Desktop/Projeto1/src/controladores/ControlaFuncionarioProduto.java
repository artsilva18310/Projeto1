/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.FuncionarioProduto;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.DAO.FuncionarioProdutoDAO;
import entidades.DAO.ProdutoDAO;

public class ControlaFuncionarioProduto {

    private final FuncionarioProdutoDAO funcionarioProdutoDAO = new FuncionarioProdutoDAO();

    /**
     * Insere uma nova relação entre funcionário e produto.
     */
    public boolean inserir(FuncionarioProduto fp) {
        try {
            funcionarioProdutoDAO.inserir(fp);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir relação funcionário-produto: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Remove a relação entre funcionário e produto.
     */
    public boolean remover(FuncionarioProduto fp) {
        try {
            funcionarioProdutoDAO.remover(fp);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao remover relação funcionário-produto: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Recupera todos os produtos relacionados a um funcionário.
     */
    public ArrayList<FuncionarioProduto> recuperarPorFuncionario(int idFuncionario) {
        try {
            return funcionarioProdutoDAO.recuperarPorFuncionario(idFuncionario);
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar produtos do funcionário: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Recupera todos os funcionários relacionados a um produto.
     */
    public ArrayList<FuncionarioProduto> recuperarPorProduto(int idProduto) {
        try {
            return funcionarioProdutoDAO.recuperarPorProduto(idProduto);
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar funcionários do produto: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    public ArrayList<FuncionarioProduto> recuperarTodos() {
    try {
        return funcionarioProdutoDAO.recuperarTodos();
    } catch (SQLException ex) {
        System.out.println("Erro ao recuperar todas as relações funcionário-produto: " + ex.getMessage());
        return new ArrayList<>();
    }
}

}

