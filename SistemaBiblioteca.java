import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    int codigo;
    String titulo;
    String autor;
    boolean disponivel;

    Livro(int codigo, String titulo, String autor) {
        this.codigo    = codigo;
        this.titulo    = titulo;
        this.autor     = autor;
        this.disponivel = true;
    }

    public String toString() {
        String status = disponivel ? "Disponível" : "Indisponível";
        return "[" + codigo + "] " + titulo + " - " + autor + " | " + status;
    }
}

public class SistemaBiblioteca {

    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> emprestar();
                case 4 -> devolver();
                case 0 -> System.out.println("Encerrando o sistema. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        // Verifica código duplicado
        for (Livro l : livros) {
            if (l.codigo == codigo) {
                System.out.println("Já existe um livro com esse código.");
                return;
            }
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        livros.add(new Livro(codigo, titulo, autor));
        System.out.println("Livro cadastrado com sucesso!");
    }

    static void listar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Livros ===");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    static void emprestar() {
        listar();
        if (livros.isEmpty()) return;

        System.out.print("\nDigite o código do livro para emprestar: ");
        int codigo = sc.nextInt();

        for (Livro l : livros) {
            if (l.codigo == codigo) {
                if (l.disponivel) {
                    l.disponivel = false;
                    System.out.println("Livro \"" + l.titulo + "\" emprestado com sucesso!");
                } else {
                    System.out.println("Este livro já está indisponível.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    static void devolver() {
        listar();
        if (livros.isEmpty()) return;

        System.out.print("\nDigite o código do livro para devolver: ");
        int codigo = sc.nextInt();

        for (Livro l : livros) {
            if (l.codigo == codigo) {
                if (!l.disponivel) {
                    l.disponivel = true;
                    System.out.println("Livro \"" + l.titulo + "\" devolvido com sucesso!");
                } else {
                    System.out.println("Este livro já está disponível.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}
