import java.util.ArrayList;
import java.util.List;

/*
 * vamos abstrair a lista de vertices e arestas
 * para uma classe abstrata Dados, similar ao que
 * Thuanny fez?
 **/
public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private List<Arvore> arvores;
	private List<Arvore> arvoresComRestricao;

	public List<Arvore> getArvores() {
		return arvores;
	}
	
	public List<Arvore> getArvoresComRestricao() {
		return arvoresComRestricao;
	}

	Grafo() {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
		this.arvores = new ArrayList<>();
		this.arvoresComRestricao = new ArrayList<>();
	}

	/*
	 * Método para verificar se o grafo é cíclico
	 * Isso vai ser útil quando estivermos inserindo os
	 * conjuntos disjuntos
	 */
	public boolean ehCiclico() {
		return false;
	}

	/*
	 * Método para criar um vértice e add ele à lista
	 * de vértices do Grafo
	 * 
	 * @param id Identificador do vértice (casa)
	 */
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
	public void addAresta(Vertice vertice1, Vertice vertice2, int custo) {
		Aresta novaAresta = new Aresta(vertice1, vertice2, custo);
		arestas.add(novaAresta);

		// adiciona a ligação nas arestas
		vertice1.adicionarLigacao(vertice2, custo);
		vertice2.adicionarLigacao(vertice1, custo);
		return;
	}

	/*
	 * Método para gerar a árvore de menor custo
	 */
	public void gerarArvore(Aresta[] vet) {
		List<Aresta> arvoreMontada = new ArrayList<>();
		Aresta[] copia = vet.clone();

		int i = 0;
		int j = 0;

		while (j < (vertices.size() - 1)) {
			// j vai contar os vertices gerados na arvore minima
			Aresta proxAresta = copia[i];

			ConjuntoDisjunto<?> representanteOrigem = copia[i].getVertice1().find();
			ConjuntoDisjunto<?> representanteDestino = copia[i].getVertice2().find();
			Vertice origem = copia[i].getVertice1();
			Vertice destino = copia[i].getVertice2();

			if (representanteOrigem != representanteDestino) {
				// if(origem.getGrau() < origem.getGrauMax() && destino.getGrau() <
				// destino.getGrauMax()) {
				arvoreMontada.add(proxAresta);
				origem.union(destino);
				origem.aumentaGrau();
				destino.aumentaGrau();
				j++;
				// }
			}
			i++;
		}

		int custoTotal = 0;
		for (Aresta a : arvoreMontada) {
			custoTotal += a.getCusto();
		}
		// System.out.println("Qnt Arestas : " + arvoreMontada.size() + " CUSTO TOTAL :"
		// + custoTotal);
		Arvore arvoreMont = new Arvore(arvoreMontada, custoTotal);
		
		geraArvoresComRestricao(arvoreMont);
		
		arvores.add(arvoreMont);
		
		
		for (Vertice vertice : vertices){
			vertice.resetaRepresentante();
			vertice.resetaGrau();
		}
	}
	
	public void geraArvoresComRestricao(Arvore arvoreMont){
		List<Aresta> arestasAtuais = new ArrayList<>();
		boolean achou = false;
		arestasAtuais = arvoreMont.getArvoreArestas();
//		System.out.println("\n*****  Arvore  *****");
//		for(Aresta a:arestasAtuais){
//			System.out.println(a.getVertice1() + "->" + a.getVertice2());
//		}
		for(int j = 0; j < arestasAtuais.size(); j++){
			achou = false;
			if(arestasAtuais.get(j).getVertice1().getGrau() >= 2 && arestasAtuais.get(j).getVertice2().getGrau() >= 2){
				achou = true;
				break;
			}
		}
		
		//tentar comparar tbm as arestas, além do custo
		for(int i = 0; i < arvoresComRestricao.size(); i++){
			int cont = 0;
			if(arvoresComRestricao.get(i).getCustoTotal() == arvoreMont.getCustoTotal()){
				List<Aresta> teste = arvoresComRestricao.get(i).getArvoreArestas();
				for(int j = 0; j < teste.size(); j++){
					if(teste.get(j).getVertice1() == arestasAtuais.get(j).getVertice1()
					&& teste.get(j).getVertice2() == arestasAtuais.get(j).getVertice2()){
						cont++;
					}
				}	
				if(cont == teste.size()){
					achou = true;
					break;
				}
			}
		}

		if(!achou){
			arvoresComRestricao.add(arvoreMont);
		}
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	// método apenas pra testar
	public void imprimeLigacoes() {
		System.out.println("Vertices: ");
		for (Vertice v : vertices) {
			System.out.println(v);
		}
		System.out.print("\n\nligações: \n");

		for (Aresta a : arestas) {
			System.out.println(a.getVertice1() + " " + a.getVertice2() + " Custo: " + a.getCusto());
		}
	}
}