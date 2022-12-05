import java.io.FileNotFoundException;
import java.util.List;

import Assets.Combinacao;
import Grafo.Aresta;
import Grafo.Grafo;
import InOut.ManipularArquivo;
import interfaceGrafica.InterfaceGrafica;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo();
		ManipularArquivo arquivo = new ManipularArquivo(args[0]);

		System.out.println("----- Lendo os dados do arquivo -----");
		int quantCasas = arquivo.lerQuantCasas();
		int limitadorArestas = arquivo.lerLimitadorAresta();

		for (int i = 0; i < quantCasas; i++) {
			grafo.addVertice(i, limitadorArestas);
		}

		arquivo.construirArestas(grafo, quantCasas);

		System.out.println("\n----- Tudo pronto! Gerando árvores... -----");
		List<Aresta> arestas = grafo.getArestas();

		Combinacao.combinacao(arestas, grafo.getVertices().size() - 1, grafo);

		List<Aresta> arvoreMinima = grafo.getArvoreMinima().getArvoreArestas();

		System.out.println("\n***** ÁRVORE MÍNIMA*****");
		System.out.println("Custo total: " + grafo.getArvoreMinima().getCustoTotal());

		for (Aresta a : arvoreMinima) {
			System.out.println(a.getVertice1() + " -> " + a.getVertice2() + " Custo: " + a.getCusto());
		}

		arquivo.escreverArvore(grafo.getArvoreMinima(), quantCasas, limitadorArestas);

		InterfaceGrafica interf = new InterfaceGrafica();
		interf.gerarGrafo(grafo);
	}
}