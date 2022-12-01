import java.util.ArrayList;
import java.util.List;

public class Combinacao {
    private static List<Aresta[]> ans = new ArrayList<>();
    private static List<Aresta> tmp = new ArrayList<>();
    private static List<Aresta> kkk = new ArrayList<>();

    
    //quando a gente remove os treco do kkk, tbm remove no ans :/
    static void makeCombiUtil(List<Aresta> arestas, int left, int k, Grafo grafo) {

        // Pushing this vector to a vector of vector
        if (k == 0) {
        	/*gambiarra mágica B)
        	 * Isso foi necessário por problemas de referência,
        	 * quando a gente passa o tmp, pq a gente sempre tá
        	 * dando remove, e como o java soca referência no
        	 * nosso rabo, isso tava deixando o vetor ans preenchido
        	 * com uma lista de arestas vazias
        	 * */
        	Aresta[] viji = new Aresta[tmp.size()];
            tmp.toArray(viji);
            viji.clone();
        	//ans.add(viji);
            
            grafo.gerarArvore(viji);
            //System.out.println("aa: " + tmp);
            //ans.add(tmp);
            //System.out.println("BBB");
            return;
        }

        // i iterates from left to n. First time
        // left will be 1
        for (int i = left; i < arestas.size(); ++i){  	
	    	tmp.add(arestas.get(i));
	    	
            makeCombiUtil(arestas, i + 1, k - 1, grafo);

            // Popping out last inserted element
            // from the vector
            tmp.remove(tmp.size() - 1);
        }
    }

    // Prints all combinations of size k of numbers
    // from 1 to n.
    static void makeCombi(List<Aresta> arestas, int k, Grafo grafo) {
        makeCombiUtil(arestas, 0, k, grafo);
    }
    
    public static void imprime(){
    	for(Aresta[] lA: ans){
    		System.out.println("\n***** Árvore *****");
    		for(Aresta a:lA){
    			System.out.println(a.getVertice1() + " -> " + a.getVertice2());
    		}
    	}
    }
    
    static int getTam(){
    	return ans.size();
    }
}

// static Vector<Vector<Integer>> ans = new Vector<Vector<Integer>>();
// static Vector<Integer> tmp = new Vector<Integer>();

// static void makeCombiUtil(int n, int left, int k)
// {

// // Pushing this vector to a vector of vector
// if (k == 0) {
// ans.add(tmp);
// for(int i = 0; i < tmp.size(); i++)
// {
// System.out.print(tmp.get(i) + " ");
// }
// System.out.println();
// return;
// }

// // i iterates from left to n. First time
// // left will be 1
// for (int i = left; i <= n; ++i)
// {
// tmp.add(i);
// makeCombiUtil(n, i + 1, k - 1);

// // Popping out last inserted element
// // from the vector
// tmp.remove(tmp.size() - 1);
// }
// }

// // Prints all combinations of size k of numbers
// // from 1 to n.
// static Vector<Vector<Integer>> makeCombi(int n, int k)
// {
// makeCombiUtil(n, 1, k);
// return ans;
// }