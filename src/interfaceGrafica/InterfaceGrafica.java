package interfaceGrafica;

import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import Arvore.Arvore;
import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

public class InterfaceGrafica implements InterfaceMonta{

	private Graph graph = new SingleGraph("arvoreMinima");
	
	public void gerarGrafo(Grafo grafo){
			Arvore arvoreMinima = grafo.getArvoreMinima();
			
			List<Aresta> arestasMinimas = arvoreMinima.getArvoreArestas();
			List<Vertice> vertices = grafo.getVertices();
			montaGrafo(vertices);
			montaGrafo(arestasMinimas, 2);
			//montaGrafo(grafo.getArestas(), 2);
			System.setProperty("org.graphstream.ui", "swing");
			graph.display();
	}

	@Override
	public void montaGrafo(List<Aresta> arestas, int numero){
		int cont = 0;
		for(Aresta a:arestas){
			graph.addEdge(Integer.toString(cont++), a.getVertice1().toString(), a.getVertice2().toString());
		}
	}

	@Override
	public void montaGrafo(List<Vertice> vertices) {
		// TODO Auto-generated method stub
		for(Vertice v:vertices){
			graph.addNode(v.toString());
		}
	}
}
