import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe gera e imprime as diferentes permutações de n objetos
 *
 */

public class Permutacao1{
    // numero da permutacao atual
    private static int cont = 0;

    // armazena a permutacao corrente
    private static Aresta[] p;

    /**
     * metodo principal: recebe o vetor cujos elementos que serao permutados
     * 
     * @param vet
     */
    public static void permuta(Aresta[] vet, Grafo grafo) {
        p = new Aresta[vet.length];
        permuta(vet, 0, grafo);
    }

    /**
     * método recursivo que implementa as permutacoes
     * 
     * @param vet
     * @param n
     */
    private static void permuta(Aresta[] vet, int n, Grafo grafo) {
        if (n == vet.length) {
            cont++;
            //imprime();
            grafo.gerarArvore(p);
        } else {
            for (int i = 0; i < vet.length; i++) {
                boolean achou = false;
                for (int j = 0; j < n; j++) {
                    if (p[j].equals(vet[i])) {
                        achou = true;
                    }
                }

                if (!achou) {
                    p[n] = vet[i];
                    permuta(vet, n + 1, grafo);
                }
            }
        }
    }

    /** imprime a permutacao corrente */
    private static void imprime() {
        System.out.println();
        System.out.print("(" + cont + ") : ");
        for (int i = 0; i < p.length; i++)
            System.out.print(p[i] + " ");
    }
}
