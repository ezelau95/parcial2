package fiesta;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Fiesta fiesta = new Fiesta("enunciado.in", "enunciado.out");
		fiesta.resolver();
	}

}
