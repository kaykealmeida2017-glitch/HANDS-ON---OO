import java.util.HashMap;
import java.util.Scanner;

class Pedido {
    int numero;
    String cliente;
    String item;
    double valor;
    String status;

    Pedido(int numero, String cliente, String item, double valor) {
        this.numero  = numero;
        this.cliente = cliente;
        this.item    = item;
        this.valor   = valor;
        this.status  = "PENDENTE";
    }

    public String toString() {
        return String.format("Pedido #%d | %s | %s | R$ %.2f | %s",
                numero, cliente, item, valor, status);
    }
}

public class SistemaLanchonete {

    static HashMap<Integer, Pedido> pedidos = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static int proximoNumero = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== LANCHONETE =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Buscar pedido pelo número");
            System.out.println("5 - Valor total dos pedidos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizarStatus();
                case 4 -> buscar();
                case 5 -> totalPedidos();
                case 0 -> System.out.println("Encerrando o sistema. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Item pedido: ");
        String item = sc.nextLine();

        System.out.print("Valor (ex: 12.50): ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Pedido p = new Pedido(proximoNumero, cliente, item, valor);
        pedidos.put(proximoNumero, p);
        System.out.println("Pedido #" + proximoNumero + " cadastrado com sucesso!");
        proximoNumero++;
    }

    static void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        System.out.println("\n=== Pedidos ===");
        for (Pedido p : pedidos.values()) {
            System.out.println(p);
        }
    }

    static void atualizarStatus() {
        listar();
        if (pedidos.isEmpty()) return;

        System.out.print("\nNúmero do pedido: ");
        int numero = sc.nextInt();
        sc.nextLine();

        Pedido p = pedidos.get(numero);
        if (p == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Status atual: " + p.status);
        System.out.println("1 - PENDENTE");
        System.out.println("2 - PREPARANDO");
        System.out.println("3 - FINALIZADO");
        System.out.print("Novo status: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> p.status = "PENDENTE";
            case 2 -> p.status = "PREPARANDO";
            case 3 -> p.status = "FINALIZADO";
            default -> { System.out.println("Opção inválida."); return; }
        }
        System.out.println("Status atualizado para: " + p.status);
    }

    static void buscar() {
        System.out.print("Número do pedido: ");
        int numero = sc.nextInt();
        sc.nextLine();

        Pedido p = pedidos.get(numero);
        if (p != null) {
            System.out.println("\n=== Pedido Encontrado ===");
            System.out.println(p);
        } else {
            System.out.println("Pedido #" + numero + " não encontrado.");
        }
    }

    static void totalPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        double total = 0;
        int finalizados = 0;

        for (Pedido p : pedidos.values()) {
            total += p.valor;
            if (p.status.equals("FINALIZADO")) finalizados++;
        }

        System.out.println("\n=== Resumo ===");
        System.out.println("Total de pedidos  : " + pedidos.size());
        System.out.println("Pedidos finalizados: " + finalizados);
        System.out.printf("Valor total        : R$ %.2f%n", total);
    }
}
