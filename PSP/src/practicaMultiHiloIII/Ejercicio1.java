package practicaMultiHiloIII;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Ejercicio1 {
	
	public int maximoNaufragosPorBarca = 15;
	public static int totalBarcas = 5;
	static int naufragosSalvados = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		// Cada barca es un hilo
		
		Random random = new Random();
		int totalNaufragos = random.nextInt(800,1000);
		int tiempoVuelta = random.nextInt(1800,2000);
		
		
		Semaphore miSemaforo = new Semaphore(2);
		Playa playa = new Playa(miSemaforo);
		ExecutorService miExecutor = Executors.newFixedThreadPool(totalBarcas);
		Thread hilo1 = new Thread();
		Thread hilo2 = new Thread();
		Thread hilo3 = new Thread();
		Thread hilo4 = new Thread();
		Thread hilo5 = new Thread();
		
		while(totalNaufragos!=0) {
			for(int i=0; i<totalBarcas; i++ ) {
				miExecutor.submit(new Hilo(playa));
				if(totalNaufragos < 0)
					totalNaufragos = 0;
				long tiempoEspera = random.nextInt(2000,3000);
				if(totalNaufragos <= 15)
					naufragosSalvados+=totalNaufragos;
				else
					naufragosSalvados+=15;
			System.out.println("Quedan " + totalNaufragos + " náufragos");
			totalNaufragos-=15;
			
			}
		}
		
		miExecutor.shutdown();
		
	}
	
	public static int getNaufragosRescatados() {
		return naufragosSalvados;
	}
	
}
