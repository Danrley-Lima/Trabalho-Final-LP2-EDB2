
public class ErroCustoAresta extends Exception{
	public ErroCustoAresta(){
		super("Erro ao adicionar aresta! A mesma possui custo menor ou igual a 0!\n\nSaindo...");
	}
}