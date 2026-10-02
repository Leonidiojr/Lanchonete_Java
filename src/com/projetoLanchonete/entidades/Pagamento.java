/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.entidades;

/**
 *
 * @author vitor
 */
public class Pagamento {
    private int codigo;
    private Pedido pedido;
    private double valor;
    private FormaPagamento formaPagamento;

    public Pagamento() {
    }

    public Pagamento(int codigo, Pedido pedido, double valor,
                     FormaPagamento formaPagamento) {
        this.codigo = codigo;
        this.pedido = pedido;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codigo=" + codigo + ", pedido=" + pedido + ", valor=" + valor + ", formaPagamento=" + formaPagamento + '}';
    }

    

    
}
