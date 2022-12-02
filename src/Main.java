import java.io.FileNotFoundException;
import java.util.List;

import Arvore.Aresta;
import Assets.Combinacao;
import Grafo.Grafo;
import InOut.manipularArquivo;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo();
		manipularArquivo arquivo = new manipularArquivo(args[0]);

		System.out.println("----- Lendo os dados do arquivo -----");
		int quantCasas = arquivo.lerQuantCasas();
		int limitadorArestas = arquivo.lerLimitadorAresta();

		for (int i = 0; i < quantCasas; i++) {
			grafo.addVertice(i, limitadorArestas);
		}

		arquivo.construirArestas(grafo, quantCasas);

		System.out.println("\n----- Tudo pronto! Gerando árvores... -----");
		List<Aresta> arestas = grafo.getArestas();

		Combinacao.makeCombi(arestas, grafo.getVertices().size() - 1, grafo);

		List<Aresta> arvoreMinima = grafo.getArvoreMinima().getArvoreArestas();

		System.out.println("\n***** ÁRVORE MÍNIMA*****");
		System.out.println("Custo total: " + grafo.getArvoreMinima().getCustoTotal());
		for (Aresta a : arvoreMinima) {
			System.out.println(a.getVertice1() + " -> " + a.getVertice2() + " Custo: " + a.getCusto());
		}

		arquivo.escreverArvore(grafo.getArvoreMinima(), quantCasas, limitadorArestas);
	}
}