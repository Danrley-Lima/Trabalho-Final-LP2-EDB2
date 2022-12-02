package interfaceGrafica;

import java.util.List;

import Grafo.Aresta;
import Grafo.Vertice;

public interface InterfaceMonta{
	public void montaGrafo(List<Aresta> arestas, int custo);
	public void montaGrafo(List<Vertice> vertices);
}
