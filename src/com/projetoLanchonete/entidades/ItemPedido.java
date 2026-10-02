/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.entidades;

/**
 *
 * @author vitor
 */
public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // RF05 - Cálculo do valor do item
    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }

   

    
}
