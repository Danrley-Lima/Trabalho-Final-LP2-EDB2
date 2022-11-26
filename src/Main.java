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
		grafo.gerarArvore();

		// char[] teste = { 'A', 'B', 'C', 'D', 'E' };
		// Permutacao.permuta(teste);
		System.out.println("\n Arestas totais: " + arestas.size());
		Aresta[] sample = new Aresta[arestas.size()];
		arestas.toArray(sample);
		Aresta[] sample1 = { sample[0], sample[1], sample[2], sample[3] };
		System.out.println("TESTE SAMPLE: " + sample.length);
		// Permutacao.permuta(arestas);
		Permutacao1.permuta(sample1);
		// grafo.gerarArvore();

	}
}
