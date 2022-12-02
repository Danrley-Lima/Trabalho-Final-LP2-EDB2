import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo();
		LeitorArquivo leitor = new LeitorArquivo(args[0]);

		System.out.println("----- Lendo os dados do arquivo -----");
		int quantCasas = leitor.lerQuantCasas();
		int limitadorArestas = leitor.lerLimitadorAresta();

		for (int i = 0; i < quantCasas; i++) {
			grafo.addVertice(i, limitadorArestas);
		}

		leitor.construirArestas(grafo, quantCasas);

		System.out.println("\n----- Tudo pronto! Gerando árvores... -----");
		List<Aresta> arestas = grafo.getArestas();

		Combinacao.makeCombi(arestas, grafo.getVertices().size() - 1, grafo);

		List<Aresta> arvoreMinima = grafo.getArvoreMinima().getArvoreArestas();

		System.out.println("\n***** ÁRVORE MÍNIMA*****");
		System.out.println("Custo total: " + grafo.getArvoreMinima().getCustoTotal());
		for (Aresta a : arvoreMinima) {
			System.out.println(a.getVertice1() + " -> " + a.getVertice2() + " Custo: " + a.getCusto());
		}
	}
}