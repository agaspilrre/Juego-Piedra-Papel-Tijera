

/** La clase Jugador va a ser la encargada de almacenar los datos como nombre de jugador, partidas que gana
 * partidas que pierde, partidas que empata y puntuacion. ademas de guardar estos datos tambien podra
 * modificarlos gracias a sus metodos y devolverlo a otras clases que lo necesiten.
 * En este caso solo se comunica con la clase JuegoPPT
 * 
 * @version 1.0
 * @author Luis Bastante
 *
 */
public class Jugador {
	
	//atributos
	
	private String nombre;
	private int partidasGanadas;
	private int partidasEmpatadas;
	private int partidasPerdidas;
	private int puntuacion;
	
	
	//constructor
	/** metodo constructor de la clase Jugador
	 * 
	 * @param nomb
	 * Le pasamos un parametro tipo string desde la clase JuegoPPT este parametro sera el
	 * nombre que el usuario habra introducido por teclado.
	 * El resto de atributos los inicializamos con un valor cero para que en los metodos de mas adelante
	 * podamos restarle o sumarle valores enteros, y tambien porque al iniciar la partida y llamar al constructor
	 * el usuario tendra cero puntos y no habra ganado perdido o empatado ninguna partida.
	 */
	
	public Jugador(String nomb){
		
		this.nombre=nomb;
		this.partidasGanadas=0;
		this.partidasEmpatadas=0;
		this.partidasPerdidas=0;
		this.puntuacion=0;
		
	}
	
	
	//metodos
	/**Metodo setNombre
	 * 
	 * @param nomb 
	 * le paso un String que sera el nombre introducido en JuegoPPT.
	 * este metodo se puede utilizar para modificar el nombre del jugador
	 */
	
	public void setNombre(String nomb){
		this.nombre=nomb;
	}
	
	/** Metoddo setPartidasGanadas
	 * 
	 * @param pg
	 * recibe un integer (un uno) desde la clase JuegoPPT y se lo sumo a partidasGanadas.
	 */
	
	public void setPartidasGanadas(int pg){
		this.partidasGanadas+=pg;
	}
	
	/** Metodo setPartidasEmpatadas
	 * 
	 * @param pem
	 * recibe un integer (un uno) desde la clase JuegoPPT y se lo sumo a partidasEmpatadas.
	 */
	
	public void setPartidasEmpatadas(int pem){
		this.partidasEmpatadas+=pem;
	}
	
	/** Metodo setPartidasPerdidas
	 * 
	 * @param pper
	 * recibe un integer (un uno) desde la clase JuegoPPT y se lo suma a partidasPerdidas
	 */
	
	public void setPartidasPerdidas(int pper){
		this.partidasPerdidas+=pper;
	}
	
	/** Metodo setPuntuacion
	 * 
	 * @param pun
	 * recibe un integer (+100 si se ha ganado la partida y -100 si se perdio la partida)
	 * se lo suma a puntuacion, si recibe un valor negativo entonces opera como una resta.
	 */
	
	public void setPuntuacion(int pun){
		this.puntuacion+=pun;
	}
	
	/** Metodo getNombre
	 * 
	 * @return
	 *  devuelve un string con el nombre, a la clase JuegoPPT
	 */
	public String getNombre(){
		return nombre;
	}
	
	/** Metodo getpartidasGanadas
	 * 
	 * @return
	 * devuelve un valor entero que sera el numero de partidas ganadas
	 */
	public int getPartidasGanadas(){
		return partidasGanadas;
	}
	
	/** Metodo getPartidasEmpatadas
	 * 
	 * @return
	 * devuelve un valor entero que sera el numero de partidas empatadas.
	 */
	public int getPartidasEmpatadas(){
		return partidasEmpatadas;
	}
	
	/** Metodo getPartidasPerdidas
	 * 
	 * @return
	 * devuelve un valor entero que sera el numero de partidas perdidas
	 */
	public int getPartidasPerdidas(){
		return partidasPerdidas;
	}
	
	/** Metodo getPuntuacion
	 * 
	 * @return
	 * devuelve un valor entero que sera la puntuacion que tenga acumulada el jugador.
	 */
	public int getPuntuacion(){
		return puntuacion;
	}
	
	

}
