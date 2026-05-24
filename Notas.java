import java.util.ArrayList;

public class Notas {
    public static void main(String[] args) {

        ArrayList<Double> notas = new ArrayList<>();

            notas.add(8.5);
            notas.add(6.0);
            notas.add(7.5);
            notas.add(9.0);

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.size();

        System.out.println("Notas da Turma: ");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ": " + notas.get(i));
        }

        System.out.printf("%nMédia da turma: %.2f%n", media);

        if (media >= 7) {
            System.out.println("Resultado: turma aprovada");
        } else {
            System.out.println("Resultado: turma reprovada");
        }
    }
}