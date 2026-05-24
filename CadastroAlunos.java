import java.util.HashMap;
import java.util.Map;

public class CadastroAlunos {
    public static void main(String[] args) {

        HashMap<Integer, String> alunos = new HashMap<>();

        alunos.put(1001, "Ana Silva");
        alunos.put(1002, "Carlos Souza");
        alunos.put(1003, "Beatriz Lima");
        alunos.put(1004, "Daniel Martins");
        alunos.put(1005, "Fernanda Costa");

        int matriculaBusca = 1003;
        System.out.println("Busca por matricula: ");
        if (alunos.containsKey(matriculaBusca)) {
            System.out.println("Matrícula " + matriculaBusca + " - " + alunos.get(matriculaBusca));
        } else {
            System.out.println("Matrícula " + matriculaBusca + " não encontrada.");
        }

        int matriculaRemover = 1002;
        System.out.println("\nRemoção de aluno");
        if (alunos.containsKey(matriculaRemover)) {
            System.out.println("Removendo: " + alunos.get(matriculaRemover));
            alunos.remove(matriculaRemover);
        } else {
            System.out.println("Matricula " + matriculaRemover + " não encontrada.");
        }

        System.out.println("\n=== Alunos Cadastrados ===");
        for (Map.Entry<Integer, String> entrada : alunos.entrySet()) {
            System.out.println("Matrícula " + entrada.getKey() + " - " + entrada.getValue());
        }

        System.out.println("\nTotal de alunos: " + alunos.size());
    }
}