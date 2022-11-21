public class Aresta {
	private int custo;
	private Vertice vertice1;
	private Vertice vertice2;
	
	Aresta(Vertice vertice1, Vertice vertice2, int custo){
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.custo = custo;
	}
	
	public int getCusto(){
		return custo;
	}
	
	public Vertice getVertice1(){
		return vertice1;
	}
	
	public Vertice getVertice2(){
		return vertice2;
	}
}
