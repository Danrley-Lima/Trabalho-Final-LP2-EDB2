import java.util.ArrayList;
import java.util.List;

public class Combinacao {
    private static List<Aresta> tmp = new ArrayList<>();

    static void makeCombiUtil(List<Aresta> arestas, int left, int k, Grafo grafo) {

        if (k == 0) {	
        	Aresta[] arestasCombinadas = new Aresta[tmp.size()];
            tmp.toArray(arestasCombinadas);
            arestasCombinadas.clone();
            
            grafo.gerarArvore(arestasCombinadas);
            return;
        }

        for (int i = left; i < arestas.size(); ++i){  	
	    	tmp.add(arestas.get(i));
	    	
            makeCombiUtil(arestas, i + 1, k - 1, grafo);

            tmp.remove(tmp.size() - 1);
        }
    }

    static void makeCombi(List<Aresta> arestas, int k, Grafo grafo) {
        makeCombiUtil(arestas, 0, k, grafo);
    }
}