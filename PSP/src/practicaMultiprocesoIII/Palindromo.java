package practicaMultiprocesoIII;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Palindromo {

	public static void main(String[] args) throws IOException {
		
//		Partiendo del ejercicio 3 de la práctica anterior, realiza los cambios necesarios para que la
//		entrada al primer programa se haga a partir de un fichero llamado texto.txt en lugar de pedir
//		por consola y las salidas se redirijan a ficheros llamados palindromo.txt y error.txt.
		
		String ruta = "bin";
        File datos = new File("src", "texto.txt");
        File salida = new File("src", "palindromo.txt");
        File error = new File("src", "error.txt");
        
        try {
			FileReader lectura = new FileReader(datos);
			FileWriter escrito = new FileWriter(salida);
			while(lectura.read()!=0) {
				
				String limpia = lectura.toString().toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
				String inversa = new StringBuilder(limpia).reverse().toString();
				
				if (limpia.equals(inversa)) {
					escrito.write(limpia + " es palindromo.\n");
					System.out.println(limpia +" es un palindromo.");
					System.exit(0);
				} else {
					escrito.write(limpia + " no es palindromo.\n");
					System.out.println(limpia + " no es un palindromo.");
					System.exit(1);
				}
			}
        lectura.close();
        escrito.close();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} // Fin main

}
