package practicaMultiHiloI;

import java.util.concurrent.atomic.AtomicReference;

public class IronMan implements Runnable {

	private static final long MS_POR_HORA = 1000;
	private static final AtomicReference<String> GANADOR = new AtomicReference<>();

	private final String nombre;
	private final double velCorrer;
	private final double velBici;
	private final double velNadar;

	public IronMan(String nombre, double velCorrer, double velBici, double velNadar) {
		this.nombre = nombre;
		this.velCorrer = velCorrer;
		this.velBici = velBici;
		this.velNadar = velNadar;
	}

	private void bici() throws InterruptedException {
		prueba("la prueba en bici", 180 / velBici);
	}

	private void marathon() throws InterruptedException {
		prueba("la marathon", 42 / velCorrer);
	}

	private void nadar() throws InterruptedException {
		prueba("la prueba de natación", 4000 / velNadar);
	}

	private void prueba(String descripcion, double horas) throws InterruptedException {
		
		System.out.println(nombre + " comienza " + descripcion);
		Thread.sleep((long) (horas * MS_POR_HORA));
		System.out.println(nombre + " ha acabado " + descripcion);
		
	}

	public void competir() throws InterruptedException {
		
		bici();
		marathon();
		nadar();
		System.out.println(nombre + " ha terminado el IronMan.");
		GANADOR.compareAndSet(null, nombre);
		
	}

	@Override
	public void run() {
		
		try {
			competir();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(nombre + " ha abandonado la carrera.");
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread pedro = new Thread(new IronMan("Pedro", 6, 20, 1000));
		Thread juan = new Thread(new IronMan("Juan", 7, 18, 2000));
		Thread vicente = new Thread(new IronMan("Vicente", 6, 30, 1000));

		pedro.start();
		juan.start();
		vicente.start();

		pedro.join();
		juan.join();
		vicente.join();

		System.out.println("¡El ganador es " + GANADOR.get() + "!");
		
	}
}
