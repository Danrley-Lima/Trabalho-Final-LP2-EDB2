import java.util.ArrayList;
import java.util.List;

public class Vertice extends ConjuntoDisjunto<Vertice> {
	private int id;
	private List<Aresta> ligacoes;
	private int grau;

	Vertice(int id) {
		this.id = id;
		this.ligacoes = new ArrayList<>();
		this.grau = 0;

		// Atributos de ConjuntoDisjunto
		this.MakeSet(this);
		/*
		 * this.ordem = 0;
		 * this.representante = this;
		 * this.valor = this;
		 */
	}

	public void adicionarLigacao(Vertice destino, int custo) {
		Aresta novaAresta = new Aresta(this, destino, custo);
		this.ordem++;
		destino.aumentaGrau();
		ligacoes.add(novaAresta);
	}

	public int getId() {
		return id;
	}

	public List<Aresta> getLigacoes() {
		return ligacoes;
	}

	public int getGrau() {
		return grau;
	}

	public void aumentaGrau() {
		this.grau++;
	}

	@Override
	public String toString() {
		return "Casa " + id;
	}
}
