package empresa;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Grafo g = new Grafo(8);
//		
//		g.agregarArista(1, 2, 1);
//		g.agregarArista(2, 3, 1);
//		g.agregarArista(2, 4, 1);
//		g.agregarArista(4, 7, 1);
//		g.agregarArista(4, 5, 1);
//		g.agregarArista(7, 6, 1);
//		g.agregarArista(7, 8, 1);
//		
//		
//		g.aplicarFloyd();
		
//		System.out.println("distancia max: " + g.getDistanciaMax() + "\n Lista de nodos: ");
//		List<Integer> listaNodos = g.getNodosDistMax();
//		for (Integer integer : listaNodos) {
//			System.out.print(integer+1 + " - "); // sumo 1 para que de el nodo
//		}
		
		Empresa empresa = new Empresa("enunciado.in", "enunciado.out");
		empresa.resolver();
	}

}
