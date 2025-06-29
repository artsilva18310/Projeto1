/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.ProdutoDAO;
import entidades.Produto;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public class ControlaProduto {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public boolean salvar(Produto p) {
        try {
            produtoDAO.salvar(p);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Produto: " + ex.getMessage());
            return false;
        }
    }


 public boolean editar( Produto p){
        try {
            produtoDAO.editar(p);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar  Produto: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean excluir(int id){
        try {
             produtoDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir  Produto: " + ex.getMessage());
            return false;
        }
    }
    
    public Produto recuperar(int id){
        try {
             Produto produto =  produtoDAO.recuperar(id);
            return produto;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Produto: " + ex.getMessage());
            return null;
        }
    }


    public ArrayList<Produto> recuperarTodos(){
        ArrayList<Produto> vetorProduto = null;
        try {
            vetorProduto = produtoDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produtos: " + ex.getMessage());
        }
        return vetorProduto;
}
    public ArrayList<Produto> recuperarTodos(String criterio) {
    try {
        return produtoDAO.recuperarTodos(criterio); // chamada nova no DAO
    } catch (SQLException ex) {
        System.out.println("Erro ao consultar produtos com critério: " + ex.getMessage());
        return null;
    }
}
}
