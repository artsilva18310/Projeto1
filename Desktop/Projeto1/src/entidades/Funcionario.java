/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author arthur.silva3
 */
public class Funcionario {

    public static void add(Funcionario f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int idfuncionario;
    private String nome;
    private String cargo;

    public Funcionario() {

    }

    public Funcionario(int idfuncionario, String nome, String cargo) {
        this.idfuncionario = idfuncionario;
        this.nome = nome;
        this.cargo = cargo;

    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void imprimeAtributos() {
        System.out.println(" idfuncionario");
        System.out.println(" nome");
        System.out.println(" cargo");
    }

 @Override
    public String toString(){
        return idfuncionario + ";" + nome + ";" + cargo  ;
    }
}

