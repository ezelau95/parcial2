import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Rescate rescate = new Rescate("enunciado.in", "enunciado.out");
		rescate.resolver();
		
		rescate = new Rescate("principellega.in", "principellega.out");
		rescate.resolver();
	}

}
