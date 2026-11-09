package practicaMultiprocesoIV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Lector {

	private static final String FICHERO = "datos.txt";
	private static final String FICHERO_LOCK = "datos.lock";

	public static void main(String[] args) {

		System.out.println("Esperando que se libere el bloqueo...");

		try (RandomAccessFile raf = new RandomAccessFile(FICHERO_LOCK, "rw");
				
				FileChannel canal = raf.getChannel();
				
				FileLock bloqueo = canal.lock()) {
			
			try (BufferedReader lector = new BufferedReader(new FileReader(FICHERO))) {

				String linea;
				while ((linea = lector.readLine()) != null) {
					System.out.println("Lector: " + linea);
				}
			}

			System.out.println("Fin de lectura del fichero.");

		} catch (IOException e) {
			System.err.println("Error de entrada/salida: " + e.getMessage());
		}
	}

} // Fin clase
