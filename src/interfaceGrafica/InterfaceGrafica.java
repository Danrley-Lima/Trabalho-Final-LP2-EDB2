package interfaceGrafica;

import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import Arvore.Arvore;
import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

public class InterfaceGrafica implements InterfaceMonta {

	private Graph graph = new SingleGraph("arvoreMinima");

	public void gerarGrafo(Grafo grafo) {
		Arvore arvoreMinima = grafo.getArvoreMinima();

		List<Aresta> arestasMinimas = arvoreMinima.getArvoreArestas();
		List<Vertice> vertices = grafo.getVertices();
		montaGrafo(vertices);
		montaGrafo(arestasMinimas, true);
		// montaGrafo(grafo.getArestas(), true);
		System.setProperty("org.graphstream.ui", "swing");

		String estilo = ""
				+ "graph{"
				+ "fill-color: #FFF, #BBB;"
				+ "fill-mode: gradient-radial;"
				+ "}"
				+ "node {"
				+ "size: 40px, 40px;"
				+ "fill-mode: image-scaled;"
				+ "fill-image:url('data/Casinha.png');"
				+ "text-mode: normal;"
				+ "text-visibility-mode: normal;"
				+ "text-alignment: under;"
				+ "}"
				+ "edge{"
				+ "size: 4px;"
				+ "fill-color: #32bd28;"
				+ "}";

		graph.setAttribute("ui.stylesheet", estilo);

		graph.display();
	}

	@Override
	public void montaGrafo(List<Aresta> arestas, boolean isAresta) {
		int cont = 0;
		for (Aresta a : arestas) {
			graph.addEdge(Integer.toString(cont++), a.getVertice1().toString(), a.getVertice2().toString());
		}
	}

	@Override
	public void montaGrafo(List<Vertice> vertices) {
		for (Vertice v : vertices) {
			graph.addNode(v.toString());
		}
	}
}
