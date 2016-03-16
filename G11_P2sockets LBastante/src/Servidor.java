
import java.net.*;
import java.io.*;



public class Servidor {

	
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		
		
		try{
			
			//se crea el servidor en un puerto determinado
			ServerSocket serv=new ServerSocket(12340);//el parametro es el puerto al que se va conectar el servidor si viene otro parametro detras es la lista
			//de espera pero como en este caso voy a utilizar hilos no me hace falta ponerlos.
			
			//ahora el servidor espera la respuesta del cliente
			while(true){
				
				//creamos el socket y apartir de el los streams de comunicacion
				System.out.println("esperando aceptacion del cliente\n");
				Socket c= serv.accept();
				Thread h=new Thread(new Hilo(c));
				h.start();
				
				
				
				
			}//parentesis while		
				
			//parentesis try
			}catch(IOException e){
				System.err.println(e);
				//parentesis catch
			}catch(SecurityException e){
				System.err.println(e);
			}
			
			
			
			
		

	}

}
