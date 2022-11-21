import java.util.ArrayList;
import java.util.List;

/*
 * vamos abstrair a lista de vertices e arestas
 * para uma classe abstrata Dados, similar ao que
 * Thuanny fez?
 **/
public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	
	Grafo(){
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}
	
	/*
	 * Método para verificar se o grafo é cíclico
	 * Isso vai ser útil quando estivermos inserindo os
	 * conjuntos disjuntos
	 * */
	public boolean ehCiclico(){
		return false;
	}
	
	/*
	 * Método para criar um vértice e add ele à lista
	 * de vértices do Grafo
	 * 
	 * @param id Identificador do vértice (casa)
	 * 
	 * */
	public void addVertice(int id){
		Vertice novoVertice = new Vertice(id);
		vertices.add(novoVertice);
	}
	
	/*
	 * Método para criar uma aresta e add ela à lista
	 * de arestas do grafo
	 * 
	 * CREIO QUE AQUI TEREMOS QUE VERIFICAR SE O GRAFO
	 * FICA CÍCLICO AO ADD A NOVA ARESTA, MAS ISSO
	 * ENVOLVE CONJUNTO DISJUNTOS, EU ACHO
	 * 
	 * @param vertice1 Vertice que quer fazer a conexão
	 * @param vertice2 Vertice que vai receber a conexão
	 * @param custo Custo da conexão
	 * 
	 * */
	public void addAresta(Vertice vertice1, Vertice vertice2, int custo){
		Aresta novaAresta = new Aresta(vertice1, vertice2, custo);
		arestas.add(novaAresta);
		
		//adiciona a ligação nas arestas
		vertice1.adicionarLigacao(vertice2, custo);
		vertice2.adicionarLigacao(vertice1, custo);
		return;
	}
	
	
	/*
	 * Método para gerar a árvore de menor custo
	public Arvore gerarArvore(){
		
	}*/
	
	public List<Vertice> getVertices(){
		return vertices;
	}
	
	public List<Aresta> getArestas(){
		return arestas;
	}
	
	//método apenas pra testar
	public void imprimeLigacoes(){
		System.out.println("Vertices: ");
		for(Vertice v:vertices){
			System.out.println("Casa " + v.getId());
		}
		System.out.print("\n\nligações: \n");
		
		for(Aresta a:arestas){
			System.out.println(a.getVertice1() + " " + a.getVertice2() + " Custo: " + a.getCusto());
		}
	}
}
