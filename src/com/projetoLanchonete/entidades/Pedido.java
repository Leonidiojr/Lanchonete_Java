/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.entidades;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vitor
 */
public class Pedido {
    private int numeroPedido;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status;
    private FormaPagamento formaPagamento;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.RECEBIDO;
    }

    public Pedido(int numeroPedido, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.dataHora = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.status = StatusPedido.RECEBIDO;
    }

    // RF03 - Adicionar produto ao pedido
    public void adicionarItem(Produto produto, int quantidade) {

        ItemPedido item = new ItemPedido(produto, quantidade);

        itens.add(item);

        calcularTotal();
    }

    // RF05 - Cálculo automático do total
    public void calcularTotal() {

        valorTotal = 0;

        for (ItemPedido item : itens) {
            valorTotal += item.calcularSubtotal();
        }
    }

    // RF04 - Alterar status
    public void alterarStatus(StatusPedido status) {
        this.status = status;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
        calcularTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numeroPedido=" + numeroPedido + ", dataHora=" + dataHora + ", cliente=" + cliente + ", itens=" + itens + ", valorTotal=" + valorTotal + ", status=" + status + ", formaPagamento=" + formaPagamento + '}';
    }

   

    
}
