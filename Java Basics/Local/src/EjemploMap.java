import java.util.HashMap;import java.util.Map;
public class EjemploMap {
	public static void main (String []args)     {
		Map <Integer,Persona> mp = new HashMap<Integer,Persona>();
		Persona p = new Persona(4,"Mar�a",167);
		mp.put(4, p); // A�adimos un objeto persona al map
		p = new Persona(1,"Marta",165);
		mp.put(1, p); // A�adimos un objeto persona al map
		p = new Persona(3,"Elena",185);
		mp.put(3, p); // A�adimos un objeto persona al map
		p = new Persona(2,"Yolanda",174);
		mp.put(2, p); // A�adimos un objeto persona al map
		p = new Persona(5,"Mar�a Dolores",169);
		mp.put(4, p); // Esto crea una colisi�n �Dos objetos no pueden tener la misma clave!
		System.out.println("Personas en el mapa: \n"+mp.toString().replaceAll(",", "\n"));	 }	}