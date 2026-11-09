package practicaMultiHiloII;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main1 {

	private static final int TOTAL_AEROPLANOS = 20;
	private static final long LLEGADA_CADA_MS = 2000;

	public static void main(String[] args) throws InterruptedException {
		Pista pista = new Pista();

		Thread reloj = new Thread(() -> {
			
			try {
				for (int s = 0;; s++) {
					System.out.println(s);
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
			}
		}, "Reloj");
		reloj.setDaemon(true);
		reloj.start();

		List<Aeroplano> aeroplanos = new ArrayList<>();
		for (int i = 1; i <= TOTAL_AEROPLANOS; i++) {
			Aeroplano.Tipo tipo = Math.random() < 0.5 ? Aeroplano.Tipo.AVION : Aeroplano.Tipo.AVIONETA;
			Aeroplano aeroplano = new Aeroplano(i, tipo, pista);
			aeroplanos.add(aeroplano);
			aeroplano.start();
			if (i < TOTAL_AEROPLANOS) {
				Thread.sleep(LLEGADA_CADA_MS);
			}
		}

		for (Aeroplano aeroplano : aeroplanos) {
			aeroplano.join();
		}
		reloj.interrupt();

		resumen(pista);
	}

	private static void resumen(Pista pista) {
		System.out.println();
		System.out.println("==== RESUMEN: ORDEN DE DESPEGUE ====");
		int orden = 1;
		for (Aeroplano a : pista.getDespegues()) {
			System.out.println(String.format(Locale.ROOT, "%2d. %-8s %-9s llegada %5.1f | entra %5.1f | despega %5.1f", orden++, a.getName(), a.getTipo(), a.getLlegada() / 1000.0, a.getEntrada() / 1000.0, a.getDespegue() / 1000.0));
		}
		System.out.println("Han despegado los " + pista.getDespegues().size() + " aeroplanos.");
	}
}

