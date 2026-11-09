package practicaMultiprocesoIV;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

public class Escritor {

	private static final String FICHERO = "datos.txt";
	private static final String FICHERO_LOCK = "datos.lock";
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {

		try (RandomAccessFile raf = new RandomAccessFile(FICHERO_LOCK, "rw");
				FileChannel canal = raf.getChannel()) {
			
			try (FileLock bloqueo = canal.lock();
					PrintWriter pw = new PrintWriter(new FileWriter(FICHERO))) {
				
				System.out.println("Establecido bloqueo para escribir los mensajes...");

				for (int i = 0; i < 10; i++) {
					pw.println("Mensaje de iteración: " + i);
					pw.flush();
	
					System.out.println("Escritor: Escrito mensaje de iteración " + i);
					
					Thread.sleep(1000 + RANDOM.nextInt(501));
				}	
			}

			System.out.println("Liberado bloqueo.");

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("El proceso ha sido interrumpido: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de entrada/salida: " + e.getMessage());
		}
	}

} // Fin clase
