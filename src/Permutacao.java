import java.util.ArrayList;
import java.util.List;

public class Permutacao {

    // numero da permutacao atual
    private static int cont = 0;

    // armazena a permutacao corrente
    private static List<Aresta> vetorArestas;

    /**
     * metodo principal: recebe o vetor cujos elementos que serao permutados
     * 
     * @param vet
     */
    public static void permuta(List<Aresta> vetorArestasParam) {
        vetorArestas = new ArrayList<>();
        permuta(vetorArestasParam, 0);
    }

    /**
     * método recursivo que implementa as permutacoes
     * 
     * @param vet
     * @param n
     */
    private static void permuta(List<Aresta> vetorArestasParam, int n) {
        if (n == vetorArestasParam.size()) {
            cont++;
            imprime();
        } else {
            for (int i = 0; i < vetorArestasParam.size(); i++) {

                boolean achou = false;

                for (int j = 0; j < n; j++) {
                    if (vetorArestas.get(j).equals(vetorArestasParam.get(i))) {
                        achou = true;
                    }
                }

                if (!achou) {
                    vetorArestas.add(n, vetorArestasParam.get(i));
                    permuta(vetorArestasParam, n + 1);
                }
            }
        }
    }

    /** imprime a permutacao corrente */
    private static void imprime() {
        System.out.println();
        System.out.print("(" + cont + ") : ");
        for (int i = 0; i < vetorArestas.size(); i++) {
            System.out.print(vetorArestas.get(i) + " ");
        }
    }
}