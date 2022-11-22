import java.util.ArrayList;
import java.util.List;

public class Vertice extends ConjuntoDisjunto{
	private int id;
	private List<Aresta> ligacoes;
	
	Vertice(int id){
		this.id = id;
		this.ligacoes = new ArrayList<>();
		
		//Atributos de ConjuntoDisjunto
		this.MakeSet(this);
		/*
		this.ordem = 0;
		this.representante = this;
		this.valor = this;
		*/
	}
	
	public void adicionarLigacao(Vertice destino, int custo){
		Aresta novaAresta = new Aresta(this, destino, custo);
		this.ordem++;
		destino.aumentaOrdem();
		ligacoes.add(novaAresta);
	}
	
	public int getId(){
		return id;
	}
	
	public List getLigacoes(){
		return ligacoes;
	}
	
	public int getOrdem(){
		return ordem;
	}
	
	public void aumentaOrdem(){
		this.ordem++;
	}
	
	@Override
	public String toString(){
		return "Casa " + id;
	}
}
