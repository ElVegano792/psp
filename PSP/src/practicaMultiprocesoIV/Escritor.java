package practicaMultiprocesoIV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.FileOutputStream;

public class Escritor {

//	Debe realizar las siguientes operaciones:
//		1. Crear o abrir el fichero datos.lock.
//		2. Obtener un FileChannel asociado al fichero de bloqueo.
//		3. Obtener un bloqueo mediante FileLock.
//		4. Mostrar por consola un mensaje indicando que se ha establecido el bloqueo.
//		5. Mientras mantenga el bloqueo, escribir 10 mensajes en datos.txt.
//		6. Después de escribir cada mensaje:
//		7. Mostrar por consola qué mensaje se ha escrito.
//		8. Esperar un tiempo aleatorio entre 1 y 1,5 segundos.
//		9. Cuando termine de escribir los 10 mensajes, liberar el bloqueo.
//		10. Mostrar por consola que el bloqueo ha sido liberado

	private static final String FICHERO = "datos.txt";
	private static final Random RANDOM = new Random();

	public static void main(String[] args) throws IOException, InterruptedException {

		File lock = new File("datos.lock");
		while (!lock.createNewFile()) {
			Thread.sleep(100);
		}
		System.out.println("Establecido bloqueo para escribir los mensajes...");

		File fichero = new File(FICHERO);
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(fichero))) {
			
			pw.flush();
			for (int i = 0; i < 10; i++) {
				long sleepTime = RANDOM.nextLong(1000, 1500);
				System.out.println("Lector: Escrito mensaje de iteracion " + i);
				pw.printf("Mensaje de iteracion %d\n", i);
				Thread.sleep(sleepTime);
			}
			System.out.println("Liberado bloqueo.");

		} catch (FileNotFoundException e) {
			System.err.printf("El fichero no se ha podido crear / abrir: %s\n", e.getMessage());
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			System.err.printf("El proceso ha sido interrumpido: %s\n", e.getMessage());
			throw new RuntimeException(e);
		}
		lock.delete();
	}

} // Fin clase
