import java.util.HashSet;

public class AlunosPresentes {
    public static void main(String[] args) {

        HashSet<String> presentes = new HashSet<>();

        // Adicionando nomes com repetições propositais
        presentes.add("Ana");
        presentes.add("Carlos");
        presentes.add("Beatriz");
        presentes.add("Ana");       // repetido
        presentes.add("Daniel");
        presentes.add("Carlos");    // repetido
        presentes.add("Fernanda");
        presentes.add("Beatriz");   // repetido

        System.out.println("Lista de presença:");
        for (String aluno : presentes) {
            System.out.println("- " + aluno);
        }

        System.out.println("\nTotal de alunos presentes: " + presentes.size());
    }
}