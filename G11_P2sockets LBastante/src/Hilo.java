import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Hilo implements Runnable {
	
	private Socket socket;
	
	//constructor
	public Hilo(Socket socket){
		
		this.socket=socket;
		
		
	}
	
	
	public void run(){
		try{
			
		
		PrintWriter salida= new PrintWriter(socket.getOutputStream(),true);
		BufferedReader entrada=new BufferedReader (new InputStreamReader (socket.getInputStream()));
		System.out.println("conexion entrada y salida establecida");
		
		JuegoPPT j=new JuegoPPT();//inicializamos el objeto ojo Juego PPT 
		j.menu(entrada,salida);
		
		
		socket.close();

		
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
