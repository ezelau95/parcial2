

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Grafo {

	private List<Nodo> nodos = new ArrayList<>();

	public void agregarNodo(Nodo nodo) {	
		nodos.add(nodo);
	}	

	public List<Nodo> getNodos() {
		return nodos;
	}
	
	public Nodo getNodo(int nombreNodo) {
		return nodos.get(nombreNodo-1);
	}
}
