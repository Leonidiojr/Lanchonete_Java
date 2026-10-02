/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.entidades;

/**
 *
 * @author vitor
 */
public class Produto {
     private int codigo;
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
    private boolean disponibilidade;

    public Produto() {
    }

    public Produto(int codigo, String nome, String descricao,
                   String categoria, double preco, boolean disponibilidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", categoria=" + categoria + ", preco=" + preco + ", disponibilidade=" + disponibilidade + '}';
    }

   

    
}
