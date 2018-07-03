package empresa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		//sc.nextLine();
		relaciones = new ArrayList<Relacion>();
		int num = 0;
		for (int i = 0; i < cantRelaciones; i++) {
			
			String nombre1 = sc.next();
			String nombre2 = sc.next();

			Empleado e1;
			Empleado e2;

			if (!empleados.containsKey(nombre1)) {
				e1 = new Empleado(nombre1, num);
				empleados.put(nombre1, e1);
				num++;
			} else {
				e1 = empleados.get(nombre1);
			}

			if (!empleados.containsKey(nombre2)) {
				e2 = new Empleado(nombre2, num);
				empleados.put(nombre2, e2);
				num++;
			}else {
				e2 = empleados.get(nombre2);
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
		
		grafo.aplicarFloyd();
		int distanciaMax = grafo.getDistanciaMax();
		List<String> listaNombres = new ArrayList<>();
		List<Integer> listaIdEmpleados = grafo.getNodosDistMax();
		
		for (Integer nroEmpl : listaIdEmpleados) {
			for (Entry<String, Empleado> empl : empleados.entrySet()) {
				if(empl.getValue().getNumero() == nroEmpl) {
					listaNombres.add(empl.getValue().getNombre());
					break;
				}
			}
		}
		
		Collections.sort(listaNombres);
		
		try {
			PrintWriter pw = new PrintWriter(super.salida);
			pw.println(distanciaMax);
			for (String nombre : listaNombres) {
				pw.println(nombre);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
