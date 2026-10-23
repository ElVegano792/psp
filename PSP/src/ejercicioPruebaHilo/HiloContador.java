package ejercicioPruebaHilo;

public class HiloContador extends Thread{
	
	Contador cosa = new Contador();
	
	public HiloContador() {
		
	}
	
	public void run() {
		
		int nun = 0;
		
		do  {
			this.cosa.sumar();
			nun++;
		} while (nun<5000);
		
	}
	
}