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
			grafo.addVertice(i);
		}
		List<Vertice> vertices = grafo.getVertices();

		leitor.construirArestas(grafo, quantCasas);

		/*
		 * grafo.addVertice(1);
		 * grafo.addVertice(2);
		 * grafo.addVertice(3);
		 * grafo.addVertice(4);
		 */
		// List<Vertice> vertices = grafo.getVertices();
		/*
		 * grafo.addAresta(vertices.get(0), vertices.get(1), 8);
		 * grafo.addAresta(vertices.get(2), vertices.get(1), 5);
		 * grafo.addAresta(vertices.get(0) , vertices.get(2), 10);
		 * grafo.addAresta(vertices.get(3), vertices.get(0), 7);
		 */
		/*
		 * Teste fora do grafo para ver se os vertices
		 * estão guardando suas ligações
		 *
		 * System.out.println("Ligações: ");
		 * for(Vertice v:vertices){
		 * List<Aresta> ligacoes = v.getLigacoes();
		 * for(Aresta a:ligacoes){
		 * System.out.println(a.getVertice1() + " " + a.getVertice2());
		 * }
		 * }
		 */
		grafo.imprimeLigacoes();

		// teste de representantes
		/*
		 * System.out.println("representante da " + vertices.get(0) + " é: " +
		 * vertices.get(0).find());
		 * System.out.println("representante da " + vertices.get(1) + " é: " +
		 * vertices.get(1).find());
		 * System.out.println("representante da " + vertices.get(2) + " é: " +
		 * vertices.get(2).find());
		 * System.out.println("representante da " + vertices.get(3) + " é: " +
		 * vertices.get(3).find());
		 */

	}
}
