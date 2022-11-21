import java.util.ArrayList;
import java.util.List;

public class Vertice {
	private int id;
	private List<Aresta> ligacoes;
	private int grau;
	
	Vertice(int id){
		this.id = id;
		this.ligacoes = new ArrayList<>();
		this.grau = 0;
	}
	
	public void adicionarAresta(Vertice destino, int custo){
		Aresta novaAresta = new Aresta(this, destino, custo);
		ligacoes.add(novaAresta);
	}
}
