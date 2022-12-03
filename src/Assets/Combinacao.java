package Assets;

import java.util.ArrayList;
import java.util.List;

import Grafo.Aresta;
import Grafo.Grafo;

public class Combinacao {
    private static List<Aresta> arestasAtuais = new ArrayList<>();

    private static void combinacaoAux(List<Aresta> arestas, int left, int k, Grafo grafo) {
        if (k == 0) {
            Aresta[] arestasCombinadas = new Aresta[arestasAtuais.size()];
            arestasAtuais.toArray(arestasCombinadas);
            arestasCombinadas.clone();

            grafo.gerarArvore(arestasCombinadas);
            return;
        }

        for (int i = left; i < arestas.size(); ++i) {
            arestasAtuais.add(arestas.get(i));
            combinacaoAux(arestas, i + 1, k - 1, grafo);
            arestasAtuais.remove(arestasAtuais.size() - 1);
        }
    }

    public static void combinacao(List<Aresta> arestas, int k, Grafo grafo) {
        combinacaoAux(arestas, 0, k, grafo);
    }
}