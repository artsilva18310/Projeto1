/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import entidades.Funcionario;
/**
 *
 * @author arthur.silva3
 */
public class Produto {
    public static void add(Produto p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
    }
    
    private int id ;
    private String nome;
    private String tipo;
    private double peso;
    private String ingrediente;
    private int qtdestoque;
    private Funcionario Funcioario;
    private String observacao;

    public Funcionario getFuncioario() {
        return Funcioario;
    }

    public void setFuncioario(Funcionario Funcioario) {
        this.Funcioario= Funcioario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
    public Produto(){
        
    }
public Produto(int id, String nome, String tipo, double peso, String ingrediente, int qtdestoque){
     this.id = id;
     this.nome = nome;
     this.tipo = tipo;
     this.peso = peso;
     this.ingrediente = ingrediente;
     this.qtdestoque = qtdestoque;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

   public void imprimeAtributos(){
        System.out.println("id");
        System.out.println("nome");
        System.out.println("tipo");
        System.out.println("peso");
        System.out.println("ingrediente");
        System.out.println("qtdestoque");

}

 @Override
    public String toString(){
        return id + ";" + nome + ";" + tipo + ";" + peso + ";" + ingrediente + ";" + qtdestoque ;
    }
}