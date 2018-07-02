package fiesta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fiesta extends EjercicioOIA{
	
	public Grafo relaciones;
	
	public Fiesta(String entrada, String salida) throws FileNotFoundException {
		super(new File(entrada), new File(salida));
		
		Scanner sc = new Scanner(super.entrada);
		relaciones = new Grafo(sc.nextInt());
		int cantRelaciones = sc.nextInt();
		
		for (int i = 0; i < cantRelaciones; i++) {
			relaciones.agregarArista(sc.nextInt()-1, sc.nextInt()-1);
		}
		sc.close();
	}

	@Override
	public void resolver() {
		relaciones.colorear();
		int max = relaciones.obtenerCantMaxNodos();
		try {
			PrintWriter pw = new PrintWriter(super.salida);
			pw.print(max);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
