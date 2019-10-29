

public class PingPong extends Thread{
	
	private String word; // Lo que va a escribir.
	private int delay; // Tiempo entre escrituras
	
	public PingPong(String queDecir,int cadaCuantosMs){
		word = queDecir; 
		delay = cadaCuantosMs; 					      }
	public void run(){ //Se sobrescribe run() de Thread
		while(true)											{
			System.out.println(word + " ");
			try{
				sleep(delay);
			} catch(InterruptedException e){ return; }		}
	}
	
	public static void main(String[] args) throws Throwable				{
		// Declaración de 2 threads
		PingPong t1 =new PingPong("PING",33);
		PingPong t2= new PingPong("PONG",10);
		// Activación
		t1.start();
		t2.start();
		// Espera 2 segundos
		try{ 
			sleep(5000);
		}catch (InterruptedException e){};
			// Finaliza la ejecución de los threads
		t1.finalize();
		t2.finalize();										}
	
	
}