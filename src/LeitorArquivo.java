import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {
    private File arquivo; // File que contém o arquivo de entrada do programa.
    private Scanner scan;

    /**
     * Recebe o arquivo inserido no parâmetro para manipular dentro da classe.
     * 
     * @param param Argv do programa com o arquivo.
     * @throws FileNotFoundException Erro caso o arquivo seja inválido
     */
    public LeitorArquivo(String param) throws FileNotFoundException {
        this.arquivo = new File(param);
        scan = new Scanner(arquivo);
    }

    public int lerQuantCasas() {
        return scan.nextInt();
    }

    public int lerLimitadorAresta() {
        return scan.nextInt();
    }

    /**
     * Constrói as arestas dos vértices, utiliza as informações contidas no arquivo.
     * 
     * @param grafo       Classe que contém os vértices que serão adicionados suas
     *                    arestas e custo.
     * @param numVertices Número de vértices para que a função saíba quantos
     *                    vértices vão ser manipulados.
     */
    public void construirArestas(Grafo grafo, int numVertices) {
        List<Vertice> vertices = grafo.getVertices();
        int custo;
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                custo = scan.nextInt();
                grafo.addAresta(vertices.get(i), vertices.get(j), custo);
            }
        }
    }
}
