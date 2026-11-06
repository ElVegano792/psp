package practicaMultiprocesoIV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//	Debe realizar las siguientes operaciones:
//		Mostrar por consola:
//			1. Esperando que se libere el bloqueo...
//			2. Abrir el fichero datos.lock.
//			3. Obtener un FileChannel.
//			4. Intentar obtener un FileLock sobre el mismo fichero utilizado por Escritor.
//			5. Una vez conseguido el bloqueo, abrir datos.txt.
//			6. Leer y mostrar por consola todas las líneas del fichero.
//			7. Indicar que ha finalizado

public class Lector {
    	private static final String FICHERO = "datos.txt";
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
        File lock = new File("datos.lock");
        while (!lock.createNewFile()) {
            Thread.sleep(100);
        }
        System.out.println("Esperando que se libere el bloqueo...");

        File fichero = new File(FICHERO);
        try {

			FileReader fichero1 = new FileReader(FICHERO); // Hay que poner la ruta completa y tiene que existir el archivo
			// FileReadrt solo permite leer, no grabar
			
			// Para imprimir hay que crear un segundo objeto llamado BufferedReader
			BufferedReader lector = new BufferedReader(fichero1);
			
			String linea = "";
			
			do {
				linea = lector.readLine();
				if(linea != null)
					System.out.println(linea);
			} while(linea != null); 
			
                System.out.println("Liberado bloqueo.");
                
                lector.close();
        } catch (FileNotFoundException e) {
            System.err.printf("El fichero no se ha abrir: %s\n", e.getMessage());
            throw new RuntimeException(e);
        } catch(Exception e) {
        	System.out.println("Error: " + e.getMessage());
        }
        lock.delete();
		
	}
	
} // Fin clase