package empresa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Empresa extends EjercicioOIA{
	
	private Map<Integer, String> empleados;
	private Grafo relaciones;
	
	public Empresa(String entrada, String salida) throws FileNotFoundException {
		super(new File(entrada), new File(salida));
		
		empleados = new HashMap<Integer, String>();
		Scanner sc = new Scanner(super.entrada);
		int cantRelaciones = sc.nextInt();
		
		relaciones = new Grafo(cantRelaciones);
		for (int i = 0; i < cantRelaciones; i++) {
			String[] linea = sc.nextLine().split(" ");
			//relaciones.agregarVertice(linea[0], linea[1]);
		}
		
	}

	@Override
	public void resolver() {
		// TODO Auto-generated method stub
		
	}
	
}
