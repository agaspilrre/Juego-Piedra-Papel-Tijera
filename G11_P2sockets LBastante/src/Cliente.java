


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//atributos de la clase cliente
	    String codigo;
		
		String texto;
		Scanner sca=new Scanner(System.in);
		

		try{
			//creamos el socket y los streams de entrada y de salida
			Socket s=new Socket("localhost",12340);//direccion(maquina) IP y puerto(aplicacion dentro de la maquina)
			PrintWriter salida= new PrintWriter(s.getOutputStream(),true);
			BufferedReader entrada= new BufferedReader (new InputStreamReader(s.getInputStream()));
			System.out.println("Buffers creados");//cuando me ejecute el servidor para saber por donde voy
			
			
			
			codigo=entrada.readLine();//guardo lo que me llega en el readline en una variable string
			
			while (!codigo.substring(0,2).equals("11")) {

				if (codigo.substring(0, 2).equals("01")) {
					System.out.println(codigo.substring(2));
				}

				else if (codigo.substring(0, 2).equals("02")) {
					System.out.println(codigo.substring(2));
					texto = sca.nextLine();
					salida.println(texto);

				}

				codigo = entrada.readLine();
			}
			
			System.out.println ("Hasta Luego");
			
			
			salida.close();
			entrada.close();
			s.close();
			sca.close();
			
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
		
		
		
	}
