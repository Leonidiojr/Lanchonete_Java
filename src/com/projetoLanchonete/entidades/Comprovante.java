/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.entidades;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author vitor
 */
public class Comprovante {
     private Pedido pedido;

    public Comprovante() {
    }

    public Comprovante(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // RF08 - Geração do comprovante
    public String gerarComprovante() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder comprovante = new StringBuilder();

        comprovante.append("================================\n");
        comprovante.append("       COMPROVANTE DE PEDIDO\n");
        comprovante.append("================================\n");

        comprovante.append("Pedido: ")
                .append(pedido.getNumeroPedido())
                .append("\n");

        comprovante.append("Data: ")
                .append(pedido.getDataHora().format(formato))
                .append("\n");

        if (pedido.getCliente() != null) {
            comprovante.append("Cliente: ")
                    .append(pedido.getCliente().getNome())
                    .append("\n");
        }

        comprovante.append("--------------------------------\n");
        comprovante.append("ITENS:\n");

        for (ItemPedido item : pedido.getItens()) {

            comprovante.append(item.getProduto().getNome())
                    .append(" x ")
                    .append(item.getQuantidade())
                    .append(" = R$ ")
                    .append(String.format("%.2f", item.calcularSubtotal()))
                    .append("\n");
        }

        comprovante.append("--------------------------------\n");

        comprovante.append("TOTAL: R$ ")
                .append(String.format("%.2f", pedido.getValorTotal()))
                .append("\n");

        comprovante.append("Pagamento: ")
                .append(pedido.getFormaPagamento())
                .append("\n");

        comprovante.append("Status: ")
                .append(pedido.getStatus())
                .append("\n");

        comprovante.append("================================\n");

        return comprovante.toString();
    }
}
