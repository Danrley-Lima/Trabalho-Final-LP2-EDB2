package Grafo;

import java.util.ArrayList;
import java.util.List;

import Arvore.Arvore;
import InOut.ErroCustoAresta;

public abstract class GrafoAbstrato {
	protected List<Vertice> vertices;
	protected List<Aresta> arestas;
	
	GrafoAbstrato(){
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}
	
	public abstract void addVertice(int id, int grauMax);
	public abstract void addAresta(Vertice vertice1, Vertice vertice2, int custo) throws ErroCustoAresta;
	public abstract void gerarArvore(Aresta[] vet);
	public abstract void geraArvoresComRestricao(Arvore arvoreMont);
	
	public List<Vertice> getVertices() {
		return vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}
}
