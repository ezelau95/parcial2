import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;


public class Rescate extends EjercicioOIA{
	
	private Grafo bosque;
	private int claroPrincesa;
	private int claroPrincipe;
	private int[] claroDragones;
	
	public Rescate(String entrada, String salida) throws FileNotFoundException {
		super(new File(entrada), new File(salida));
		
		Scanner sc = new Scanner(this.entrada);
		int cantNodos = sc.nextInt();
		int cantAristas = sc.nextInt();
		int cantDragones = sc.nextInt();
		claroDragones = new int[cantDragones]; 
		
		bosque = new Grafo();
		
		for (int i = 0; i < cantNodos; i++) {
			bosque.agregarNodo(new Nodo(i+1));
		}
		
		claroPrincesa = sc.nextInt();
		claroPrincipe = sc.nextInt();
		
		for (int i = 0; i < cantDragones; i++) {
			claroDragones[i] = sc.nextInt(); 
		}
		
		for (int i = 0; i < cantAristas; i++) {
			Nodo origen = bosque.getNodo(sc.nextInt());
			Nodo destino = bosque.getNodo(sc.nextInt());
			int costo = sc.nextInt();
			origen.agregarDestino(destino, costo);
			destino.agregarDestino(origen, costo);
		}
		
		sc.close();
	}


	@Override
	public void resolver() {
		
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.calcularRutaMasCortaDesdeOrigen(bosque, bosque.getNodo(claroPrincesa));
		
		try {
			PrintWriter pw = new PrintWriter(this.salida);
			
			int costoPrincipe = bosque.getNodo(claroPrincipe).getDistancia();
			
			for (int i = 0; i < claroDragones.length; i++) {
				int costoDragonActual = bosque.getNodo(claroDragones[i]).getDistancia();
				if (costoDragonActual < costoPrincipe) {
					pw.print("INTERCEPTADO");
					pw.close();
					return;
				}
			}
			
			if (costoPrincipe == Integer.MAX_VALUE) {
				pw.print("NO HAY CAMINO");
			}
			List<Nodo> recorrido = bosque.getNodo(claroPrincipe).getCaminoMasCorto();
			Collections.reverse(recorrido);
			pw.print(claroPrincipe + " ");
			for (Nodo nodo : recorrido) {
				pw.print(nodo.getNombre() + " ");
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
