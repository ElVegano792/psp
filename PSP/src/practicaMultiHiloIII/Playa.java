package practicaMultiHiloIII;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Playa {
	Semaphore miSemaforo;

	public Playa(Semaphore miSemaforo) {
		super();
		this.miSemaforo = miSemaforo;
	}
	
	public void rescatar (String nombre) {
		Random random = new Random();
		try {
			System.out.println("ESPERANDO semaforo hilo:" + nombre);
			this.miSemaforo.acquire();
			// 1
			System.out.println("La balsa actual es: " + nombre + " y rescatamos ");
			Thread.sleep(random.nextInt(2000,3000));
			// 2
			System.out.println("La balsa actual es: " + nombre + " y rescatamos ");
			Thread.sleep(random.nextInt(2000,3000));
			// 3
			System.out.println("La balsa actual es: " + nombre + " y rescatamos ");
			Thread.sleep(random.nextInt(2000,3000));
			// 4
			System.out.println("La balsa actual es: " + nombre + " y rescatamos ");
			Thread.sleep(random.nextInt(2000,3000));
			// 5
			System.out.println("La balsa actual es: " + nombre + " y rescatamos ");
			Thread.sleep(random.nextInt(2000,3000));
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		this.miSemaforo.release();
	}

}