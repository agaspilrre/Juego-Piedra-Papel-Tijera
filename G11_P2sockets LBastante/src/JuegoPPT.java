
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;


/** Clase JuegoPPT
 * Clase estatica para que pueda estar vinculada con el main, por lo que no lleva constructor.
 * Clase encargada de generar menu y mantener la comunicacion con el usuario
 * recoge los datos que genera el usuario por teclado y los envia a las clases Jugador y PiedrapapelTijera
 * tambien muestra al usuario informacion por pantalla
 * 
 * @version 1.0
 * @author Luis
 *
 */
public class JuegoPPT {
	
	//atributos
	//creo objetos de las clases a las que voy ha tener que llamar mas adelante
	
	
	private  Jugador nomb;
	private  PiedraPapelTijera opcion;
	private  BufferedReader entrada;
	private  PrintWriter salida;
	
	
	
	//cambio la clase estatica a una clase normal para poder usar la conexion cliente servidor
	//metodo constructor vacio.
	
	public JuegoPPT(){
		
	}
	
	
	
	
	//al ser una clase estatica no tiene constructor es estatica para poder vincularla con el main
	
	//metodo
	/** Metodo menu
	 * encargado de generar instrucciones menu del juego y la comunicacion con el usuario
	 * ademas ennvia valores a las clases Jugador y PiedraPapelTijera y recibe de estos otros valores
	 * que este metodo se encarga de mostrarle al usuario
	 * 
	 */
	//este metodo recibe los parametros de lectura y escritura del servidor
	public void menu(BufferedReader entrada, PrintWriter salida){
		
		this.salida=salida;
		this.entrada=entrada;
		
		
		//inicializo el scanner para poder meter datos por teclado
		
		
		//creo las variables que voy a necesitar para que mi programa se ejecute correctamente
		String enteroCliente;
		int opc;
		int contadorparper;
		int contadorpargan;
		int contadorparem;
		int resultado;
		String nombre;//tengo que darle un valor porque si no me da error en el codigo hasta que no le pase el cliente un nombre
		
		try {
		//muestra por pantalla la bienvenida e instrucciones del juego
		salida.println("01 BIENVENIDO AL JUEGO PIEDRA PAPEL TIJERA");
		salida.println("01 INSTRUCCIONES: Consigue ganar a la maquina el maximo numero de veces posible Si pierdes tres veces seras eliminado");
		
		//recoge el nombre de usuario por teclado
		salida.println("02 Introduce tu nombre:");
		
		
			nombre=entrada.readLine();
		//variable=entrada.readLine para recibir el scanner del cliente
		
		//envia el nombre introducido al constructor de la clase Jugador
		nomb=new Jugador(nombre);
		
		
		do{
			opcion=new PiedraPapelTijera();//llamo al constructor de PiedrapapelTijera para generar un nuevo
			//aleatorio cada vez que repita el bucle
			
		    //System.out.println(opcion.getOpcionMaquina());
		   //comprobar la opcion de la maquina
			
		   //me muestra la puntuacion y el nombre del usuario
		   salida.println("01 Tu puntuacion es:"+nomb.getPuntuacion());
		   salida.println("01 Elige una opcion "+nomb.getNombre());
		
		   //mostramos el menu al usuario
		  do{
		    salida.println("01 1-PIEDRA");
		    salida.println("01 2-PAPEL");
		    salida.println("01 3-TIJERA");
		    salida.println("02 4-SALIR");
		
		    //recogemos la opcion que introduce por teclado el usuario y guardamos este valor en la variable opc
		    
			enteroCliente=entrada.readLine();
			
		    
			opc=Integer.parseInt(enteroCliente);//con esto transformo el string que recibo del cliente en un numero entero
			
	       }while(opc<1 || opc >4);//si el numero introducido no esta entre uno y cuatro vuelve a decir que introduzcas la opcion
		  
		
		 salida.println("01"+opc);//para comprobar q el dato se mete correctamente.
		
		 //llamo al metodo de comparar jugada de la clase PiedraPapelTijera
		 //le paso los parametros la opcion elegida por el jugador y el random que genera la maquina
		 //el entero que devuelve este metodo lo guardo en la variable resultado
		 resultado=opcion.CompararJugada(opc, opcion.getOpcionMaquina());
		
		
		// System.out.println("el resultado devuelto es:"+resultado);
		 
		 //comunicacion al usuario del resultado de la partida
		 //dependiendo del valor de la variable resultado nos dira el resultado de la partida
		 
		 //si pierde la partida
		 
		 if(resultado==1 || resultado==4 || resultado==7){
			 if(resultado==1){
				 salida.println("01 Has escogido piedra");
				 salida.println("01 La maquina ha elegido papel");
				 salida.println("01 Lo siento pierdes esta partida "+nomb.getNombre());
			 }
			 
			 else if(resultado==4){
				 salida.println("01 Has escogido papel");
				 salida.println("01 La maquina ha elegido tijera");
				 salida.println("01 Lo siento pierdes esta partida "+nomb.getNombre());
				 
			 }
			 
			 else if(resultado==7){
				 salida.println("01 Has escogido tijera");
				 salida.println("01 La maquina ha elegido piedra");
				 salida.println("01 Lo siento pierdes esta partida "+nomb.getNombre());
			 }
			 
			 
			 nomb.setPartidasPerdidas(1);//le pasamos un uno al metodo mencionado de la clase Jugador cada vez que perdemos una partida
			 nomb.setPuntuacion(-100);//le pasamos -100 al metodo mencionado para que opere como resta y nos quite cien puntos cada vez que perdamos una partida
			 
			 
			 
		 }
		 
		 //si gana la partida
		 else if(resultado==2||resultado==5||resultado==8){
			 
			 if(resultado==2){
				 salida.println("01 Has escogido piedra");
				 salida.println("01 La maquina ha elegido tijera");
				 salida.println("01 Felicidades!!has ganado esta partida "+nomb.getNombre());
			 }
			 
			 else if(resultado==5){
				 salida.println("01 Has escogido papel");
				 salida.println("01 La maquina ha elegido piedra");
				 salida.println("01 Felicidades!!has ganado esta partida  "+nomb.getNombre());
				 
			 }
			 
			 else if(resultado==8){
				 salida.println("01 Has escogido tijera");
				 salida.println("01 La maquina ha elegido papel");
				 salida.println("01 Felicidades!!has ganado esta partida "+nomb.getNombre());
			 }
			 
			 nomb.setPartidasGanadas(1);//le pasamos un uno cada vez que se gane una partida al metodo de la clase Jugador
			 nomb.setPuntuacion(100);//le pasamos la puntuacion obtenida al metodo de la clase Jugador cada vez que ganemos
			 
		 }
		 
		 //si empata la partida
		 else if(resultado==0||resultado==3||resultado==6){
			 
			 if(resultado==0){
				 salida.println("01 Has escogido piedra");
				 salida.println("01 La maquina ha elegido piedra");
				 salida.println("01 Has empatado con la maquina "+nomb.getNombre());
			 }
			 
			 else if(resultado==3){
				 salida.println("01 Has escogido papel");
				 salida.println("01 La maquina ha elegido papel");
				 salida.println("01 Has empatado con la maquina  "+nomb.getNombre());
				 
			 }
			 
			 else if(resultado==6){
				 salida.println("01 Has escogido tijera");
				 salida.println("01 La maquina ha elegido tijera");
				 salida.println("01 Has empatado con la maquina "+nomb.getNombre());
			 }
			 
			 nomb.setPartidasEmpatadas(1);// le pasamos un uno cada vez que la partida sea empate
			 
		 }
		 
		 //llamamos a estos tres metodos de la clase jugador para que nos devuelva el valor y lo guardamos en variables de tipo integer
		 //para llevar la cuenta de los resultados obtenidos en las partidas jugadas
		contadorparper=nomb.getPartidasPerdidas();
		contadorpargan=nomb.getPartidasGanadas();
		contadorparem=nomb.getPartidasEmpatadas();
		
		//muestra al usuario las partidas perdidas, ganadas y empatadas mediante los contadores
		 salida.println("01 las partidas perdidas son: "+contadorparper);
		 salida.println("01 las partidas ganadas  son: "+contadorpargan);
		 salida.println("01 las partidas empatadas son: "+contadorparem);
		 
		 
		}while(opc!=4 && contadorparper!=3);//si pulsamos el numero 4 o el numero de partidas perdidas es tres se sale del bucle y terminaria la partida
		
		//cuando finaliza el juego mostramos los resultados del jugador.
		
		salida.println("01 EL JUEGO HA TERMINADO\n RESULTADOS:");
		salida.println("01 JUGADOR: "+nomb.getNombre());
		salida.println("01 PUNTUACION: "+nomb.getPuntuacion());
		salida.println("01 PARTIDAS PERDIDAS: "+contadorparper);
	    salida.println("01 PARTIDAS GANADAS: "+contadorpargan);
		salida.println("01 PARTIDAS EMPATADAS: "+contadorparem);
		
		salida.println("11 HASTA LA PROXIMA VEZ");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	
	/** Metodo main
	 * 
	 * @param args
	 * aqui llamamos a al metodo menu de la clase JuegoPPT
	 */








