package practicaMultiprocesoIII;

import java.io.File;
import java.io.FileReader;

public class PedirPalindromo {

	public static void main(String[] args) {
		
        String ruta = "bin";

        try {
        	File entrada = new File("src","texto.txt");
        	File salida = new File("src","palindromo.txt");
        	File error = new File("src","error.txt");
            FileReader fichero = new FileReader(entrada);
            
            String linea = "";
            
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "practicaMultiprocesoIII.Palindromo", linea);
            pb.redirectInput(entrada);
            pb.redirectOutput(salida);
            pb.redirectError(error);
            
            pb.start();
            
            System.out.println("Hecho");
            
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
