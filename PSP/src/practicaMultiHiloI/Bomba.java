package practicaMultiHiloI;

import java.util.concurrent.atomic.AtomicBoolean;

public class Bomba implements Runnable {

	public enum Modo {
		CONTADOR, ARTIFICIERO
	}

	private static final AtomicBoolean RESUELTA = new AtomicBoolean(false);
	private static Thread hiloBomba;
	private static Thread hiloArtificiero;

	private final Modo modo;

	public Bomba(Modo modo) {
		this.modo = modo;
	}

	private void contador() {
		
		try {
			for (int i = 9; i >= 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			if (RESUELTA.compareAndSet(false, true)) {
				System.out.println("PUUUUUMMMMMMM");
				hiloArtificiero.interrupt();
			}
		} catch (InterruptedException e) {
			System.out.println("La bomba ha sido desactivada.");
		}
	}

	private void artificiero() {
		
		System.out.println("El artificiero comienza a desactivar la bomba.");
		try {
			Thread.sleep(9500 + (long) (Math.random() * 1001));
			if (RESUELTA.compareAndSet(false, true)) {
				System.out.println("El artificiero ha desactivado la bomba.");
				hiloBomba.interrupt();
			} else {
				System.out.println("El artificiero ha perecido.");
			}
		} catch (InterruptedException e) {
			System.out.println("El artificiero ha perecido.");
		}
	}

	@Override
	public void run() {
		switch (modo) {
		case CONTADOR -> contador();
		case ARTIFICIERO -> artificiero();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		hiloBomba = new Thread(new Bomba(Modo.CONTADOR), "Bomba");
		hiloArtificiero = new Thread(new Bomba(Modo.ARTIFICIERO), "Artificiero");

		hiloBomba.start();
		Thread.sleep(50);
		hiloArtificiero.start();

		hiloBomba.join();
		hiloArtificiero.join();
		
	}
}
