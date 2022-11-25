import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo();
		LeitorArquivo leitor = new LeitorArquivo(args[0]);

		int casa;
		int quantCasas = leitor.lerQuantCasas();
		int limitadorArestas = leitor.lerLimitadorAresta();

		System.out.println("**** Quantidade de casas: " + quantCasas + ". Limitador de arestas: " + limitadorArestas);

		// Adiciona ao grafo a quantidade de instâncias de vértices correspondentes.
		for (int i = 1; i <= quantCasas; i++) {
			grafo.addVertice(i, limitadorArestas);
		}
		List<Vertice> vertices = grafo.getVertices();

		leitor.construirArestas(grafo, quantCasas);

		grafo.imprimeLigacoes();

		grafo.gerarArvore();

	}
}
