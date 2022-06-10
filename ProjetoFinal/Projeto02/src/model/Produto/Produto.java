/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Trocar
 */
public class Produto {
    private int ID;
    private String nome;
    private double valor;
    private String sabor;
    private String tamanho;
    private String descricao;
    private int qtde_estoque;
    private String disponivel;
    private int qtde;
    private double valorTotal;
    private double valorCompra;

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    
    
    public Produto(int ID, String nome, double valor, String sabor, String tamanho, String descricao, int qtde_estoque, String disponivel) {
        this.ID = ID;
        this.nome = nome;
        this.valor = valor;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.qtde_estoque = qtde_estoque;
        this.disponivel = disponivel;
    }

    public Produto() {
       
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(int qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return  nome + " de "+ sabor+ ": " + valor + " reais";
    }

    

}
