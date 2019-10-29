
public class PruebaRunnable {

	public static void main(String[] args) {
		// Los objetos r1 y r2 definen la funcionalidad.
		// (definen los métodos run())
		PingPong2 r1 = new PingPong2("PING",3);
		PingPong2 r2 = new PingPong2("PONG",1);
		// Se crean los threads
		Thread t1 = new Thread(r1);
		Thread t2= new Thread(r2);
		// Se activan los threads
		t1.start();
		t2.start();
	}
}
