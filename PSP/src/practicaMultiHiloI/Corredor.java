package practicaMultiHiloI;

import java.util.Random;

public class Corredor extends Thread {

	private static final Random RANDOM = new Random();

	private final String equipo;
	private final String nombre;

	public Corredor(String equipo, String nombre) {
		super(equipo + ": " + nombre);
		this.equipo = equipo;
		this.nombre = nombre;
	}

	
	public void correr100() {
		System.out.println(equipo + ": " + nombre + " comienza su relevo.");
		long inicio = System.currentTimeMillis();
		try {
			for (int tramo = 0; tramo < 10; tramo++) {
				Thread.sleep(950 + RANDOM.nextInt(101));
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(equipo + ": " + nombre + " ha abandonado su relevo.");
			return;
		}
		double segundos = Math.round((System.currentTimeMillis() - inicio) / 10.0) / 100.0;
		System.out.println(equipo + ": " + nombre + " ha acabado su relevo - Ha tardado: " + segundos + " segundos.");
	}

	@Override
	public void run() {
		correr100();
	}
}
