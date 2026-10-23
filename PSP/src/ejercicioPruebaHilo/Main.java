package ejercicioPruebaHilo;

public class Main {

	public static void main(String[] args) {
		
		Contador c = new Contador();
		
		HiloContador c1 = new HiloContador();
		HiloContador c2 = new HiloContador();
		HiloContador c3 = new HiloContador();
		HiloContador c4 = new HiloContador();
		HiloContador c5 = new HiloContador();
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		
		while(c1.isAlive() || c2.isAlive() || c3.isAlive() || c4.isAlive() || c5.isAlive()) {
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(c.getContador());
	}

}
