package interfaceGrafica;

import java.util.List;

import Grafo.Aresta;
import Grafo.Vertice;

public interface InterfaceMonta{
	public void montaGrafo(List<Aresta> arestas, boolean isAresta);
	public void montaGrafo(List<Vertice> vertices);
}
