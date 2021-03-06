package ranking;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

import datatypes.pair;

/**
 * Classe dels millors temps
 * @author Marc Soldevilla
 */

public class BestTime extends Ranking {
	//atributos
	Hashtable<Integer, ArrayList<pair<String, Integer> > > hash;
	
	//metodos//
	/**
	 * Funcion creadora
	 */
	public BestTime()
	//Funcion Creadora
	{
		hash = new Hashtable<Integer, ArrayList<pair<String, Integer> > >(); //TODO: Integer : Tamany
															   //String user, Float temps
															
	}
	
	/**
	 * 	Demana el valor de N pel tamany del KenKen i imprimeix el ranking
	 */
	public void getBestTime() 
	{
		System.out.println("Introduce el valor N, por el tama�o del Kenken NxN: ");
		int x = in.nextInt();
		for (Integer key : hash.keySet()) {
			if (key == x) {
				for (pair<String, Integer> i: hash.get(key)) {
					System.out.println("Size: "+key+"x"+key+" Time: "+i.getFirst()+" User: "+i.getSecond());
				}
			}
		}
	}
		
	/**
	 * Imprime todos los tiempos de todos los usuarios de todos los kenkens resueltos 
	 */
	public void getBestTimeGlobal() 
	{
		for (Integer key : hash.keySet()) {
			for (pair<String, Integer> i: hash.get(key)) {
				System.out.println("Size: "+key+"x"+key+" Time: "+i.getSecond()+" User: "+i.getFirst());
			}
		}		
	}
	
	/**
	 * Imprime lo tiempos de las partidas del usuario 
	 */
	public void getBestTimeUser() 
	{
		System.out.println("Introduce el nombre del usuario: ");
		String x = in.nextLine();
		for (Integer key : hash.keySet()) {
			for (int i = 0; i <hash.get(key).size(); ++i) {
				if (hash.get(key).get(i).getFirst() == x) System.out.println("Size: "+key+"x"+key+" Time: "+hash.get(key).get(i).getFirst()+" User: "+hash.get(key).get(i).getSecond());
			}
			
		}
	}
	
	/**
	 * Guarda en el ranking los valores pasados
	 * @param f - Tiempo invertido
	 * @param user - Usuario
	 * @param tam_KK - Tamano del KenKen
	 */
	public void setValue(Integer f, String user, Integer tam_KK) 
	{
		ArrayList<pair<String, Integer> > ar = hash.get(tam_KK);
		if (ar == null) {
			ar = new ArrayList<pair<String, Integer> >();
			hash.put(tam_KK, ar);
		}
		pair <String, Integer> p = new pair<String, Integer>(user, f);
		hash.get(tam_KK).add(p); 

	}
}
