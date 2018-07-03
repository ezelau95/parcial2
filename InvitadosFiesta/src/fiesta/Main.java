package fiesta;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Fiesta fiesta = new Fiesta("enunciado.in", "enunciado.out");
		fiesta.resolver();
		System.out.println("-------------");
		
		fiesta = new Fiesta("bipartito.in", "bipartito.out");
		fiesta.resolver();
		System.out.println("-------------");
		
		fiesta = new Fiesta("2nodos.in", "2nodos.out");
		fiesta.resolver();
		System.out.println("-------------");
		
	}

}
