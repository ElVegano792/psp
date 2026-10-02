package gestionProcesosConFicheros;

import java.io.File;

public class PedirFichero {

	public static void main(String[] args) {
		// ¿En la clase Process está el sigueiente método?
		File directorio = new File("../gestionProcesosConFicheros/bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","gestionProcesosConFicheros.Calcular");
		
	}

}
