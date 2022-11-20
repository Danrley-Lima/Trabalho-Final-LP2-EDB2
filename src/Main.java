public class Main {
	public static void main(String[] args) {
		ConjuntoDisjunto c1 = new ConjuntoDisjunto();
		ConjuntoDisjunto c2 = new ConjuntoDisjunto();
		ConjuntoDisjunto c3 = new ConjuntoDisjunto();
		c1.MakeSet(1);
		c2.MakeSet(2);
		c3.MakeSet(3);
		
		c1.Union(c2);
		c3.Union(c1);
		System.out.println(c3.Find());
		System.out.println(c1.Find());
	}
}
