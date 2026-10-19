package practicaMultiprocesoIII;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Palindromo {

	public static void main(String[] args) throws IOException {

		File datos = new File("src", "texto.txt");
		File salida = new File("src", "palindromo.txt");
		File error = new File("src", "error.txt");

		FileWriter ficheroError = new FileWriter(error);
		int codigo = 0;

		try {
			FileReader lectura = new FileReader(datos);

			int c;
			StringBuilder texto = new StringBuilder();
			while ((c = lectura.read()) != -1) {
				texto.append((char) c);
			}
			lectura.close();

			String limpia = texto.toString().toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
			String inversa = new StringBuilder(limpia).reverse().toString();

			FileWriter escrito = new FileWriter(salida);
			if (limpia.equals(inversa)) {
				escrito.write(limpia + " es palindromo.");
			} else {
				escrito.write(limpia + " no es palindromo.");
				codigo = 1;
			}
			escrito.close();

		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error, guardado en error.txt");
			ficheroError.write(e.getMessage());
			codigo = 2;
		}

		ficheroError.close();
		System.exit(codigo);
	} // Fin main

}