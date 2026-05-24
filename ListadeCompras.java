import java.util.ArrayList;

public class ListadeCompras {
    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();

            lista.add("Arroz");
            lista.add("Feijão");
            lista.add("Leite");
            lista.add("Ovos");
            lista.add("Pão");

        System.out.println("lista de compras: ");
        for (String produto : lista) {
            System.out.println(produto);
        }

        System.out.println("\nTotal de produtos: " + lista.size());
    }
}