/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.FuncionarioDAO;
import entidades.Funcionario;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author arthur.silva3
 */
public class ControlaFuncionario {

    //Funcionario vetorFuncionarios[] = new Funcionario[20];
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public boolean salvar(Funcionario f) {
        try {
            funcionarioDAO.salvar(f);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar Funcionario: " + ex.getMessage());
            return false;
        }
    }

    public boolean editar(Funcionario f) {
        try {
            funcionarioDAO.editar(f);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar Funcionario: " + ex.getMessage());
            return false;
        }

    }

    public boolean excluir(int idfuncionario) {
        try {
            funcionarioDAO.excluir(idfuncionario);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Funcionario: " + ex.getMessage());
            return false;
        }
    }

    public Funcionario recuperar(int idfuncionario) {
        try {
            Funcionario funcionario = funcionarioDAO.recuperar(idfuncionario);
            return funcionario;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Funcionario: " + ex.getMessage());
            return null;
        }
    }

    public ArrayList<Funcionario> recuperarTodos() {
        ArrayList<Funcionario> vetorFuncionario = null;
        try {
            vetorFuncionario = funcionarioDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Funcionarios: " + ex.getMessage());
        }
        return vetorFuncionario;
    }

    public ArrayList<Funcionario> recuperarTodos(String criterio) {
        ArrayList<Funcionario> vetorFuncionario = null;
        try {
            vetorFuncionario = funcionarioDAO.recuperarTodos(criterio);
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar clientes: " + ex.getMessage());
        }
        return vetorFuncionario;
    }
}
