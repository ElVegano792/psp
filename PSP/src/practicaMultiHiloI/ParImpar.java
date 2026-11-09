package practicaMultiHiloI;

public class ParImpar extends Thread {

	private final boolean pares;

	public ParImpar(boolean pares) {
		super(pares ? "Hilo-pares" : "Hilo-impares");
		this.pares = pares;
	}

	public void generar() {
		
		int inicio = pares ? 2 : 1;
		for (int i = inicio; i <= 10; i += 2) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

	@Override
	public void run() {
		generar();
	}

	public static void main(String[] args) throws InterruptedException {
		
		ParImpar impares = new ParImpar(false);
		ParImpar pares = new ParImpar(true);

		impares.start();
		pares.start();

		impares.join();
		pares.join();
		
	}
}
