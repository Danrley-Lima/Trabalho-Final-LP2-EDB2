
public class Permutacoes {
    private static Aresta[] p; // Armazena a permutação atual

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
}
