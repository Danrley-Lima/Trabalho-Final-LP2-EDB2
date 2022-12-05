package Arvore;

import java.util.ArrayList;
import java.util.List;
import Grafo.Aresta;

public class Arvore {
    private List<Aresta> arvoreArestas;
    private int custoTotal = 0;

    public Arvore(List<Aresta> arvoreArestas, int custoTotal) {
        this.arvoreArestas = new ArrayList<>(arvoreArestas);
        this.custoTotal = custoTotal;
    }

    public List<Aresta> getArvoreArestas() {
        return arvoreArestas;
    }

    public void setArvoreArestas(List<Aresta> arvoreArestas) {
        this.arvoreArestas = arvoreArestas;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(int custoTotal) {
        this.custoTotal = custoTotal;
    }
}
