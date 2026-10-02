/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetoLanchonete.visao;
import com.projetoLanchonete.entidades.Cliente;
import com.projetoLanchonete.entidades.Comprovante;
import com.projetoLanchonete.entidades.Pedido;
import com.projetoLanchonete.entidades.Produto;
import com.projetoLanchonete.entidades.FormaPagamento;
import com.projetoLanchonete.entidades.StatusPedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8);

    static List<Produto> produtos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {

          System.setOut(new java.io.PrintStream(
            System.out,
            true,
            java.nio.charset.StandardCharsets.UTF_8
    ));
          
        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("       SISTEMA DE PEDIDOS");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("5 - Cadastrar cliente");
            System.out.println("6 - Listar clientes");
            System.out.println("7 - Criar pedido");
            System.out.println("8 - Listar pedidos");
            System.out.println("9 - Alterar status do pedido");
            System.out.println("10 - Registrar pagamento");
            System.out.println("11 - Emitir comprovante");
            System.out.println("0 - Sair");
            System.out.println("=================================");

            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    listarProdutos();
                    break;

                case 3:
                    alterarProduto();
                    break;

                case 4:
                    excluirProduto();
                    break;

                case 5:
                    cadastrarCliente();
                    break;

                case 6:
                    listarClientes();
                    break;

                case 7:
                    criarPedido();
                    break;

                case 8:
                    listarPedidos();
                    break;

                case 9:
                    alterarStatus();
                    break;

                case 10:
                    registrarPagamento();
                    break;

                case 11:
                    emitirComprovante();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }


    // =========================================
    // RF01 - CADASTRO DE PRODUTOS
    // =========================================

    public static void cadastrarProduto() {

        System.out.println("\n=== CADASTRO DE PRODUTO ===");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Preço: ");
String precoTexto = scanner.nextLine().replace(",", ".");
double preco = Double.parseDouble(precoTexto);

        System.out.print("Está disponível? (S/N): ");
        char resposta = scanner.next().charAt(0);

        boolean disponibilidade =
                resposta == 'S' || resposta == 's';

        Produto produto = new Produto(
                codigo,
                nome,
                descricao,
                categoria,
                preco,
                disponibilidade
        );

        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }


    // =========================================
    // RF01 - CONSULTAR PRODUTOS
    // =========================================

    public static void listarProdutos() {

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {

            System.out.println("-----------------------------");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Preço: R$ " +
                    String.format("%.2f", produto.getPreco()));
            System.out.println("Disponível: " +
                    (produto.isDisponibilidade() ? "Sim" : "Não"));
        }
    }


    // =========================================
    // RF01 - ALTERAR PRODUTO
    // =========================================

    public static void alterarProduto() {

        System.out.println("\n=== ALTERAR PRODUTO ===");

        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {

            if (produto.getCodigo() == codigo) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        produtoEncontrado.setNome(scanner.nextLine());

        System.out.print("Nova descrição: ");
        produtoEncontrado.setDescricao(scanner.nextLine());

        System.out.print("Nova categoria: ");
        produtoEncontrado.setCategoria(scanner.nextLine());

        System.out.print("Novo preço: ");
String precoTexto = scanner.nextLine().replace(",", ".");
double novoPreco = Double.parseDouble(precoTexto);

produtoEncontrado.setPreco(novoPreco);

        System.out.print("Está disponível? (S/N): ");
        char resposta = scanner.next().charAt(0);

        scanner.nextLine();
        
        produtoEncontrado.setDisponibilidade(
                resposta == 'S' || resposta == 's'
        );

        System.out.println("Produto alterado com sucesso!");
    }


    // =========================================
    // RF01 - EXCLUIR PRODUTO
    // =========================================

    public static void excluirProduto() {

        System.out.println("\n=== EXCLUIR PRODUTO ===");

        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {

            if (produto.getCodigo() == codigo) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        produtos.remove(produtoEncontrado);

        System.out.println("Produto excluído com sucesso!");
    }


    // =========================================
    // RF02 - CADASTRO DE CLIENTES
    // =========================================

    public static void cadastrarCliente() {

        System.out.println("\n=== CADASTRO DE CLIENTE ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("E-mail (opcional): ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(
                nome,
                telefone,
                email
        );

        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }


    // =========================================
    // RF02 - LISTAR CLIENTES
    // =========================================

    public static void listarClientes() {

        System.out.println("\n=== CLIENTES ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {

            Cliente cliente = clientes.get(i);

            System.out.println("-----------------------------");
            System.out.println("Código: " + (i + 1));
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("E-mail: " + cliente.getEmail());
        }
    }


    // =========================================
    // RF03 + RF05 - CRIAR PEDIDO
    // =========================================

    public static void criarPedido() {

        System.out.println("\n=== NOVO PEDIDO ===");

        System.out.print("Número do pedido: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = null;

        System.out.print("Deseja informar um cliente? (S/N): ");
        char resposta = scanner.next().charAt(0);
        scanner.nextLine();

        if (resposta == 'S' || resposta == 's') {

            if (clientes.isEmpty()) {
                System.out.println("Não existem clientes cadastrados.");
            } else {

                listarClientes();

                System.out.print(
                        "Digite o número do cliente: "
                );

                int numeroCliente = scanner.nextInt();
                scanner.nextLine();

                if (numeroCliente >= 1 &&
                        numeroCliente <= clientes.size()) {

                    cliente = clientes.get(numeroCliente - 1);

                } else {

                    System.out.println(
                            "Cliente inválido. Pedido ficará sem cliente."
                    );
                }
            }
        }

        Pedido pedido = new Pedido(numero, cliente);

        // Adicionar produtos
        char continuar;

        do {

            listarProdutos();

            if (produtos.isEmpty()) {
                System.out.println(
                        "Cadastre produtos antes de criar um pedido."
                );
                return;
            }

            System.out.print("\nDigite o código do produto: ");
            int codigoProduto = scanner.nextInt();

            Produto produtoEncontrado = null;

            for (Produto produto : produtos) {

                if (produto.getCodigo() == codigoProduto) {
                    produtoEncontrado = produto;
                    break;
                }
            }

            if (produtoEncontrado == null) {

                System.out.println("Produto não encontrado!");

            } else if (!produtoEncontrado.isDisponibilidade()) {

                System.out.println(
                        "Esse produto está indisponível!"
                );

            } else {

                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();

                if (quantidade <= 0) {

                    System.out.println(
                            "Quantidade inválida!"
                    );

                } else {

                    pedido.adicionarItem(
                            produtoEncontrado,
                            quantidade
                    );

                    System.out.println(
                            "Produto adicionado ao pedido!"
                    );
                }
            }

            System.out.print(
                    "Deseja adicionar outro produto? (S/N): "
            );

            continuar = scanner.next().charAt(0);

        } while (continuar == 'S' || continuar == 's');

        pedidos.add(pedido);

        System.out.println("\nPedido criado com sucesso!");

        System.out.println(
                "Valor total: R$ " +
                String.format("%.2f", pedido.getValorTotal())
        );
    }


    // =========================================
    // RF07 - CONSULTAR PEDIDOS
    // =========================================

    public static void listarPedidos() {

        System.out.println("\n=== PEDIDOS ===");

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        for (Pedido pedido : pedidos) {

            System.out.println("-----------------------------");

            System.out.println(
                    "Pedido: " +
                    pedido.getNumeroPedido()
            );

            System.out.println(
                    "Cliente: " +
                    (pedido.getCliente() != null
                            ? pedido.getCliente().getNome()
                            : "Não informado")
            );

            System.out.println(
                    "Status: " +
                    pedido.getStatus()
            );

            System.out.println(
                    "Total: R$ " +
                    String.format(
                            "%.2f",
                            pedido.getValorTotal()
                    )
            );

            System.out.println(
                    "Pagamento: " +
                    pedido.getFormaPagamento()
            );
        }
    }


    // =========================================
    // RF04 - ALTERAR STATUS
    // =========================================

    public static void alterarStatus() {

        System.out.println("\n=== ALTERAR STATUS ===");

        System.out.print("Número do pedido: ");
        int numero = scanner.nextInt();

        Pedido pedido = encontrarPedido(numero);

        if (pedido == null) {

            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("\nEscolha o novo status:");

        System.out.println("1 - Recebido");
        System.out.println("2 - Em preparação");
        System.out.println("3 - Pronto para entrega");
        System.out.println("4 - Entregue");
        System.out.println("5 - Cancelado");

        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {

            case 1:
                pedido.setStatus(StatusPedido.RECEBIDO);
                break;

            case 2:
                pedido.setStatus(StatusPedido.EM_PREPARACAO);
                break;

            case 3:
                pedido.setStatus(StatusPedido.PRONTO_PARA_ENTREGA);
                break;

            case 4:
                pedido.setStatus(StatusPedido.ENTREGUE);
                break;

            case 5:
                pedido.setStatus(StatusPedido.CANCELADO);
                break;

            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println("Status alterado com sucesso!");
    }


    // =========================================
    // RF06 - PAGAMENTO
    // =========================================

    public static void registrarPagamento() {

        System.out.println("\n=== PAGAMENTO ===");

        System.out.print("Número do pedido: ");
        int numero = scanner.nextInt();

        Pedido pedido = encontrarPedido(numero);

        if (pedido == null) {

            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("\nForma de pagamento:");

        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão de débito");
        System.out.println("3 - Cartão de crédito");
        System.out.println("4 - PIX");

        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {

            case 1:
                pedido.setFormaPagamento(
                        FormaPagamento.DINHEIRO
                );
                break;

            case 2:
                pedido.setFormaPagamento(
                        FormaPagamento.CARTAO_DEBITO
                );
                break;

            case 3:
                pedido.setFormaPagamento(
                        FormaPagamento.CARTAO_CREDITO
                );
                break;

            case 4:
                pedido.setFormaPagamento(
                        FormaPagamento.PIX
                );
                break;

            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println(
                "Pagamento registrado com sucesso!"
        );
    }


    // =========================================
    // RF08 - COMPROVANTE
    // =========================================

    public static void emitirComprovante() {

        System.out.println("\n=== COMPROVANTE ===");

        System.out.print("Número do pedido: ");
        int numero = scanner.nextInt();

        Pedido pedido = encontrarPedido(numero);

        if (pedido == null) {

            System.out.println("Pedido não encontrado!");
            return;
        }

        Comprovante comprovante =
                new Comprovante(pedido);

        System.out.println();

        System.out.println(
                comprovante.gerarComprovante()
        );
    }


    // =========================================
    // MÉTODO AUXILIAR
    // =========================================

    public static Pedido encontrarPedido(int numero) {

        for (Pedido pedido : pedidos) {

            if (pedido.getNumeroPedido() == numero) {
                return pedido;
            }
        }

        return null;
    }
}
