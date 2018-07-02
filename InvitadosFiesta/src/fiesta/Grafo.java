package fiesta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// This class represents an undirected graph using adjacency list
public class Grafo {
	private int numeroNodos; // No. of vertices
	private LinkedList<Integer> listaAdyacencias[]; // Adjacency List
	private LinkedList<Integer> coloresPorNodo;
	
	// Constructor
	public Grafo(int v) {
		numeroNodos = v;
		listaAdyacencias = new LinkedList[v];
		coloresPorNodo = new LinkedList<>();
		
		for (int i = 0; i < v; ++i) {
			listaAdyacencias[i] = new LinkedList<Integer>();
		}
	}

	// Function to add an edge into the graph
	void agregarArista(int nodoOrigen, int nodoDestino) {
		listaAdyacencias[nodoOrigen].add(nodoDestino);
		listaAdyacencias[nodoDestino].add(nodoOrigen); // Graph is undirected
	}

	// Assigns colors (starting from 0) to all vertices and
	// prints the assignment of colors
	void colorear() {
		int[] nodos = new int[numeroNodos];
		
		// Initialize all vertices as unassigned
		Arrays.fill(nodos, -1);

		// Assign the first color to first vertex
		nodos[0] = 0;

		// A temporary array to store the available colors. False
		// value of available[cr] would mean that the color cr is
		// assigned to one of its adjacent vertices
		boolean disponible[] = new boolean[numeroNodos];

		// Initially, all colors are available
		Arrays.fill(disponible, true);

		// Assign colors to remaining V-1 vertices
		for (int u = 1; u < numeroNodos; u++) {
			// Process all adjacent vertices and flag their colors
			// as unavailable
			Iterator<Integer> it = listaAdyacencias[u].iterator();

			while (it.hasNext()) {
				int i = it.next();
				if (nodos[i] != -1) {
					disponible[nodos[i]] = false;
				}
			}

			// Find the first available color
			int color;
			for (color = 0; color < numeroNodos; color++) {
				if (disponible[color]) {
					break;
				}
			}

			nodos[u] = color; // Assign the found color

			// Reset the values back to true for the next iteration
			Arrays.fill(disponible, true);
		}
		
		// print the result
		for (int numeroNodo = 0; numeroNodo < numeroNodos; numeroNodo++) {
			coloresPorNodo.add(nodos[numeroNodo]);
			System.out.println("Nodo " + numeroNodo + " --->  Color " + nodos[numeroNodo]);
		}
	}
	
	public int obtenerCantMaxNodos() {
		Collections.sort(coloresPorNodo);
		ListIterator<Integer> iter = coloresPorNodo.listIterator();
		int cantMax = 1;
		int anterior = 0;
		if (iter.hasNext()) {
			anterior = iter.next();
		} 
		
		while(iter.hasNext()) {
			int n = iter.next();
			if (n == anterior) {
				cantMax++;
			} else
				break;
		}
		return cantMax;
	}
}
