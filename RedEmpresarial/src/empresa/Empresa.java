package empresa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Empresa extends EjercicioOIA {

	private Map<String, Empleado> empleados;
	private Grafo grafo;
	private List<Relacion> relaciones;

	public Empresa(String entrada, String salida) throws FileNotFoundException {
		super(new File(entrada), new File(salida));

		empleados = new HashMap<String, Empleado>();
		Scanner sc = new Scanner(this.entrada);
		int cantRelaciones = sc.nextInt();

		for (int i = 0; i < cantRelaciones; i++) {
			int num = 0;

			String[] linea = sc.nextLine().split(" ");

			Empleado e1;
			Empleado e2;

			if (!empleados.containsKey(linea[0])) {
				e1 = new Empleado(linea[0], num);
				empleados.put(linea[0], e1);
				num++;
			} else {
				e1 = empleados.get(linea[0]);
			}

			if (!empleados.containsKey(linea[1])) {
				e2 = new Empleado(linea[1], num);
				empleados.put(linea[1], e2);
				num++;
			}else {
				e2 = empleados.get(linea[1]);
			}
			
			Relacion r = new Relacion(e1, e2);
			relaciones.add(r);
		}

		grafo = new Grafo(empleados.size());
		
		for (Relacion relacion : relaciones) {
			grafo.agregarArista(relacion.getE1().getNumero(), relacion.getE2().getNumero(), 1);
		}
		

	}

	@Override
	public void resolver() {
		// TODO Auto-generated method stub

	}

}
