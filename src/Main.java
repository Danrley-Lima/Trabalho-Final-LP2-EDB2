import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo();
		LeitorArquivo leitor = new LeitorArquivo(args[0]);

		int quantCasas = leitor.lerQuantCasas();
		int limitadorArestas = leitor.lerLimitadorAresta();

		// Adiciona ao grafo a quantidade de instâncias de vértices correspondentes.
		for (int i = 0; i < quantCasas; i++) {
			grafo.addVertice(i, limitadorArestas);
		}
		// List<Vertice> vertices = grafo.getVertices();
		List<Aresta> arestas = grafo.getArestas();

		leitor.construirArestas(grafo, quantCasas);

		grafo.imprimeLigacoes();

		Aresta[] vetorArestasRaw = new Aresta[arestas.size()];
		
		arestas.toArray(vetorArestasRaw);
		
		System.out.println(grafo.getArestas().size());
		
		//Permutacoes.permuta(vetorArestasRaw, grafo);

//		System.out.println("\nTamanho do vetor de árvores: " +
//		grafo.getArvores().size());
		
		//grafo.geraArvoresComRestricao();
		//System.out.println("\nQtd arvores com restrição: " + grafo.getArvoresComRestricao().size());
		//É PRA FAZER N-1 VERTICES
		Combinacao.makeCombi(arestas, grafo.getVertices().size()-1, grafo);
		//System.out.println("Árvores possíveis: " + Combinacao.getTam());
		//Combinacao.imprime();
		
		System.out.println("Arvores com restrição: " + grafo.getArvoresComRestricao().size());
		List<Arvore> arvores = grafo.getArvoresComRestricao();
		List<Aresta> arvoreMinima = grafo.getArvoreMinima().getArvoreArestas();
		
		System.out.println("\n***** ÁRVORE MÍNIMA*****");
		System.out.println("Custo total: " + grafo.getArvoreMinima().getCustoTotal());
		for(Aresta a: arvoreMinima){
			System.out.println(a.getVertice1() + " -> " + a.getVertice2() + " Custo: " + a.getCusto());
		}
	}
}