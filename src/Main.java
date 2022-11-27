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
		List<Aresta> arestas = grafo.getArestas();

		leitor.construirArestas(grafo, quantCasas);

		grafo.imprimeLigacoes();

		System.out.println("\nMOSTRANDO CONEXÕES E CUSTO");

		// System.out.println("\n Arestas totais: " + arestas.size());
		// Aresta[] sample = new Aresta[arestas.size()];
		// arestas.toArray(sample);
		// Aresta[] sample1 = { sample[0], sample[1], sample[2], sample[3] };
		// System.out.println("TESTE SAMPLE: " + sample.length);
		// Permutacao.permuta(arestas);

		// teste
		Aresta[] sample = new Aresta[arestas.size()];
		arestas.toArray(sample);

		Permutacao1.permuta(sample, grafo);
		System.out.println("\nTamanho do vetor de árvores: " + grafo.getArvores().size());

		for (int i = 0; i < grafo.getArvores().size(); i++) {
			System.out.println(" i : " + grafo.getArvores().get(i));
		}

		// for (var aresta : grafo.getArvores()) {
		// System.out.println("Árvore individual: ");
		// for (Aresta aresta2 : aresta) {
		// System.out.println(aresta2.getCusto() + " <<<");
		// }
		// }

	}
}
