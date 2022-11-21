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
		return;
	}
	
	/*
	 * Método para criar uma aresta e add ela à lista
	 * de arestas do grafo
	 * 
	 * @param vertice1 Vertice que quer fazer a conexão
	 * @param vertice2 Vertice que vai receber a conexão
	 * @param custo Custo da conexão
	 * 
	 * */
	public void addAresta(Vertice vertice1, Vertice vertice2, int custo){
		return;
	}
	
	
	/*
	 * Método para gerar a árvore de menor custo
	public Arvore gerarArvore(){
		
	}*/
}
