package empresa;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private int[][] matrizAdyacencia;
	private int dimension;
	private int distanciaMax;

	public Grafo(int cantidadNodos) {
		dimension = cantidadNodos;
		matrizAdyacencia = new int[cantidadNodos][cantidadNodos];
		distanciaMax = 1;
		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				matrizAdyacencia[i][j] = -1;
			}
		}

	}

	public void agregarArista(int origen, int destino, int costo) {
		matrizAdyacencia[origen][destino] = costo;
		matrizAdyacencia[destino][origen] = costo;// no dirigido
	}

	public void aplicarFloyd() {
		
		for (int k = 0; k <= dimension - 1; k++) {
			for (int i = 0; i <= dimension - 1; i++) {
				for (int j = 0; j <= dimension - 1; j++)

					if (i == j) {
						matrizAdyacencia[i][j] = 0;
					} else if (matrizAdyacencia[i][k] != -1 && matrizAdyacencia[k][j] != -1) {
						matrizAdyacencia[i][j] = funcionfloyd(matrizAdyacencia[i][j],
								matrizAdyacencia[i][k] + matrizAdyacencia[k][j]);
					}
			}
		}

		obtenerMaximo();
	}

	private int funcionfloyd(int i, int j) {

		if (i == -1 && j == -1) {
			return -1;
		} else if (i == -1) {
			return j;
		} else if (j == -1) {
			return i;
		} else if (i > j) {
			return j;
		} else {
			return i;
		}
	}

	private void obtenerMaximo() {

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (matrizAdyacencia[i][j] > distanciaMax) {
					distanciaMax = matrizAdyacencia[i][j];
				}
			}
		}
	}

	public int getDistanciaMax() {
		return this.distanciaMax;
	}

	public List<Integer> getNodosDistMax() {

		ArrayList<Integer> listaNodos = new ArrayList<Integer>();

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (matrizAdyacencia[i][j] == distanciaMax) {
					if (!listaNodos.contains(i)) {
						listaNodos.add(i);
					}
					if (!listaNodos.contains(j)) {
						listaNodos.add(j);
					}
				}
			}
		}

		return listaNodos;
	}
}
