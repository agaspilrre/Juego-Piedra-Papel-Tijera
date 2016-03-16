

 

import java.util.Random; //importamos paquete que contiene ramdom para poder usarlo

/** clase PiedraPapelTijera
 * Esta clase se encarga de generar un numero aleatorio que sera la opcion de la maquina, recibe la opcion
 * escogida por el jugador.
 * Compara la opcion de maquina y jugador y devuelve un resultado.
 * 
 * @version 1.0
 * @author Luis Bastante
 */

public class PiedraPapelTijera {
	
	//atributos
	
	private int opcMaquina;
	private Random aleatorio;
	
	//constructor
	/** Metodo Constructor de PiedraPapelTijera
	 * Genera un numero aleatorio comprendido entre el uno y el tres y lo guarda en la variable opcMaquina.
	 * Cada vez que llamemos al constructor nos generara un numero aleatorio nuevo
	 */
	public PiedraPapelTijera() {
		
	 aleatorio=new Random();
	 opcMaquina=aleatorio.nextInt(3)+1;	 
		
	}

	//metodos
	
	/** Metodo getOpcionMaquina
	 * 
	 * @return
	 * devuelve el valor aleatorio entero que genero el constructor
	 * metodo para comprobar la opcion que eligio la maquina
	 */
	public int getOpcionMaquina(){
		
		return opcMaquina;
	}
	
	/** Metodo CompararJugada
	 * 
	 * @param opcj
	 * @param opcm
	 * recibe dos enteros, la opcion que eligio el usuario desde la clase JuegoPPT y la opcion de la maquina
	 * generada por el random. este metodo compara estos dos parametros
	 * 
	 * @return
	 * devuelve un valor integer diferente, dependiendo del valor que tengan los dos parametros
	 * que recibe el metodo.
	 */
	public int CompararJugada(int opcj, int opcm){
		
		//si el jugador escoge piedra 0 empate 1 pierde 2 gana
		//maquina piedra
		if(opcj==1 && opcm==1){
			return 0;
		}
		//maquina papel
		else if(opcj==1 && opcm==2){
			return 1;
		}
		//maquina tijera
		else if(opcj==1 && opcm==3){
			return 2;
		}
		
		//si el jugador escoge papel 3 empate 4pierde 5 gana
		//maquina piedra
		else if(opcj==2 && opcm==1){
			return 5;
		}
		//maquina papel
		else if(opcj==2 && opcm==2){
			return 3;
		}
		//maquina tijera
		else if(opcj==2 && opcm==3){
			return 4;
		}
		
		//si el jugador escoge tijera 6 empate 7 pierde 8 gana
		//maquina piedra
		else if(opcj==3 && opcm==1){
			return 7;
		}
		//maquina papel
		else if(opcj==3 && opcm==2){
			return 8;
		}
		
		//maquina tijera
		else if(opcj==3 && opcm==3){
			return 6;
		}
		return 9;
	}
	
	
}
