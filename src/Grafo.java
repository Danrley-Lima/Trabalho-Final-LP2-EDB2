import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * vamos abstrair a lista de vertices e arestas
 * para uma classe abstrata Dados, similar ao que
 * Thuanny fez?
 **/
public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;

	Grafo() {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}

	/*
	 * Método para verificar se o grafo é cíclico
	 * Isso vai ser útil quando estivermos inserindo os
	 * conjuntos disjuntos
	 */
	public boolean ehCiclico() {
		return false;
	}

	/*
	 * Método para criar um vértice e add ele à lista
	 * de vértices do Grafo
	 * 
	 * @param id Identificador do vértice (casa)
	 * 
	 * IDEIA: Ao criar um novo vertice, cria um novo conjunto
	 * disjunto.
	 */
	public void addVertice(int id, int grauMax) {
		Vertice novoVertice = new Vertice(id, grauMax);

		vertices.add(novoVertice);
	}

	/*
	 * Método para criar uma aresta e add ela à lista
	 * de arestas do grafo
	 * 
	 * @param vertice1 Vertice que quer fazer a conexão
	 * 
	 * @param vertice2 Vertice que vai receber a conexão
	 * 
	 * @param custo Custo da conexão
	 */
	public void addAresta(Vertice vertice1, Vertice vertice2, int custo) {
		Aresta novaAresta = new Aresta(vertice1, vertice2, custo);
		arestas.add(novaAresta);

		// adiciona a ligação nas arestas
		vertice1.adicionarLigacao(vertice2, custo);
		vertice2.adicionarLigacao(vertice1, custo);
		return;
	}

	/*
	 * Método para gerar a árvore de menor custo
	 */
	public /* Arvore */void gerarArvore() {
		// ordena o array de arestas
		/*
		 * vai ordenar o array original ou criar um array novo ordenado?
		 * vamo ordenar o array original, se ñ fizer sentido, a gente
		 * cria um novo array e ordena ele
		 */

		List<Aresta> arvoreResultado = new ArrayList<>();

		Collections.sort(arestas);

		int i = 0;
		int j = 0;
		// int grauMax = 2;

		while (j < (vertices.size() - 1)) {
			// j vai contar os vertices gerados na arvore minima
			Aresta proxAresta;
			proxAresta = arestas.get(i);

			ConjuntoDisjunto<?> representanteOrigem = arestas.get(i).getVertice1().find();
			ConjuntoDisjunto<?> representanteDestino = arestas.get(i).getVertice2().find();
			Vertice origem = arestas.get(i).getVertice1();
			Vertice destino = arestas.get(i).getVertice2();
			System.out.println("TESTE: " + j);
			j++;
			// if (representanteOrigem != representanteDestino) {
			// if (origem.getGrau() < origem.getGrauMax() && destino.getGrau() <
			// destino.getGrauMax()) {
			// arvoreResultado.add(proxAresta);
			// origem.union(destino);
			// origem.aumentaGrau();
			// destino.aumentaGrau();
			// j++;
			// }
			// }
			// i++;
		}

		// ver resultado
		int custoTotal = 0;
		for (Aresta a : arvoreResultado) {
			System.out.println(a.getVertice1() + " -> " + a.getVertice2() + " custo: " + a.getCusto());
			custoTotal += a.getCusto();
		}
		System.out.println("CUSTO TOTAL : " + custoTotal);

		for (var x : arestas) {
			System.out.println(x.getCusto());
		}
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	// método apenas pra testar
	public void imprimeLigacoes() {
		System.out.println("Vertices: ");
		for (Vertice v : vertices) {
			System.out.println(v);
		}
		System.out.print("\n\nligações: \n");

		for (Aresta a : arestas) {
			System.out.println(a.getVertice1() + " " + a.getVertice2() + " Custo: " + a.getCusto());
		}
	}
}
