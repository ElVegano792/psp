package practicaMultiHiloIII;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Ejercicio1 {
	
	public Integer maximoNaufragosPorBarca = 15;
	public static int totalBarcas = 5;
	
	public static void main(String[] args) {
		
//		En una isla hay unos náufragos. Su número al detalle no se conoce, pero están entre 800 y
//		1.000.
//		Desde un barco en alta mar inician el rescate. Van a utilizar 5 barcas para rescatarlos. En
//		cada una de las barcas caben 15 náufragos.
//		Queremos organizar el rescate, pero la playa a la que podemos llegar con las balsas es
//		pequeña y sólo caben 2 balsas a la vez. En la barca 1 hay marineros con más experiencia
//		en el rescate y por tanto siempre tendrá prioridad sobre las otras barcas para entrar en la
//		playa.
//		Cuando están en la playa, las barcas tardan entre 2 y 3 segundos en subir a bordo a todos
//		los náufragos que caben.
//		Una vez salen de la playa, las barcas tardan entre 1’8 y 2 segundos en llevar a los
//		náufragos al barco en alta mar y volver a la playa.
//		Haremos un informe del rescate, viendo el tiempo tardado y cuantos náufragos ha
//		rescatado cada balsa.
//		Todas las balsas deben participar en el rescate.
//		Los hilos deben arrancarse con la interfaz ExecutorService y deben pararse cuando el
//		rescate haya concluido. El contador también debe parar cuando el rescate haya concluído.
		
		// Cada barca es un hilo
		
		Random random = new Random();
		int totalNaufragos = random.nextInt(800,1000);
		int tiempoVuelta = random.nextInt(1800,2000);
		
		Semaphore miSemaforo = new Semaphore(2);
		Playa playa = new Playa(miSemaforo);
		ExecutorService miExecutor = Executors.newFixedThreadPool(totalBarcas);
		
		while(totalNaufragos>=0) {
			for(int i=0; i<totalBarcas; i++ ) {
				miExecutor.submit(new Hilo(playa));
				if(totalNaufragos < 0)
					totalNaufragos = 0;
				int tiempoEspera = random.nextInt(2000,3000);
			System.out.println("Quedan " + totalNaufragos + " náufragos");
			totalNaufragos-=15;
						
			}
		}
		
		miExecutor.shutdown();
		
	}
	
}
