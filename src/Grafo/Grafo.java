package Grafo;

import java.util.ArrayList;
import java.util.List;

import Arvore.Arvore;
import ConjuntoDisjunto.ConjuntoDisjunto;
import InOut.ErroCustoAresta;

public class Grafo extends GrafoAbstrato {
	private Arvore arvoreMinima;

	public Grafo() {
		super();
		this.arvoreMinima = null;
	}

	/*
	 * Método para criar um vértice e add ele à lista
	 * de vértices do Grafo
	 * 
	 * @param id Identificador do vértice (casa)
	 */
	@Override
	public void addVertice(int id, int grauMax) {
		Vertice novoVertice = new Vertice(id, grauMax);
		vertices.add(novoVertice);
	}

	/*
	 * Método para criar uma aresta e add ela à lista
	 * de arestas do grafo
	 * 
	 * @param vertice1 Vertice que quer fazer a conexão
	 * 
	 * @param vertice2 Vertice que vai receber a conexão
	 * 
	 * @param custo Custo da conexão
	 */
	@Override
	public void addAresta(Vertice vertice1, Vertice vertice2, int custo) throws ErroCustoAresta {
		if (custo == 0) {
			throw new ErroCustoAresta();
		}
		Aresta novaAresta = new Aresta(vertice1, vertice2, custo);
		arestas.add(novaAresta);

		vertice1.adicionarLigacao(vertice2, custo);
		vertice2.adicionarLigacao(vertice1, custo);
		return;
	}

	@Override
	public void gerarArvore(Aresta[] vet) {
		List<Aresta> arvoreMontada = new ArrayList<>();
		Aresta[] copia = vet.clone();

		int i = 0;
		int j = 0;
		while (j < (vertices.size() - 1)) {
			if (i == vertices.size() - 1) {
				break;
			}
			// j vai contar os vertices gerados na arvore minima
			Aresta proxAresta = copia[i];

			ConjuntoDisjunto<?> representanteOrigem = copia[i].getVertice1().find();
			ConjuntoDisjunto<?> representanteDestino = copia[i].getVertice2().find();
			Vertice origem = copia[i].getVertice1();
			Vertice destino = copia[i].getVertice2();

			if (representanteOrigem != representanteDestino) {
				arvoreMontada.add(proxAresta);
				origem.union(destino);
				origem.aumentaGrau();
				destino.aumentaGrau();
				j++;
			}
			i++;
		}

		int custoTotal = 0;
		for (Aresta a : arvoreMontada) {
			custoTotal += a.getCusto();
		}
		Arvore arvoreMont = new Arvore(arvoreMontada, custoTotal);
		geraArvoresComRestricao(arvoreMont);

		for (Vertice vertice : vertices) {
			vertice.resetaRepresentante();
			vertice.resetaGrau();
		}
	}

	public void geraArvoresComRestricao(Arvore arvoreMont) {
		List<Aresta> arestasAtuais = new ArrayList<>();
		boolean eInvalida = false;
		arestasAtuais = arvoreMont.getArvoreArestas();

		for (int j = 0; j < arestasAtuais.size(); j++) {
			eInvalida = false;
			int grauMax = arestasAtuais.get(j).getVertice1().getGrauMax();
			if (arestasAtuais.get(j).getVertice1().getGrau() > grauMax
					|| arestasAtuais.get(j).getVertice2().getGrau() > grauMax) {
				eInvalida = true;
				break;
			}

			if (arestasAtuais.size() < vertices.size() - 1) {
				eInvalida = true;
				break;
			}
		}

		if (!eInvalida) {
			if (arvoreMinima == null) {
				arvoreMinima = arvoreMont;
			} else {
				if (arvoreMont.getCustoTotal() < arvoreMinima.getCustoTotal()) {
					arvoreMinima = arvoreMont;
				}
			}
		}
	}

	public Arvore getArvoreMinima() {
		return arvoreMinima;
	}
}