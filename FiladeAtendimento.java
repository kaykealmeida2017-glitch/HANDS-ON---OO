import java.util.LinkedList;
import java.util.Queue;

public class FiladeAtendimento {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Beatriz");
        fila.add("Daniel");
        fila.add("Fernanda");

        System.out.println("=== Fila de Atendimento ===");
        System.out.println("Clientes na fila: " + fila);

        System.out.println("\n=== Proximo da Fila ===");
        System.out.println("Proximo a ser atendido: " + fila.peek());

        System.out.println("\n=== Atendendo Clientes ===");
        System.out.println("Atendendo: " + fila.poll());
        System.out.println("Atendendo: " + fila.poll());

        System.out.println("\n=== Fila Atualizada ===");
        for (String cliente : fila) {
            System.out.println("- " + cliente);
        }

        System.out.println("\nClientes aguardando: " + fila.size());
    }
}