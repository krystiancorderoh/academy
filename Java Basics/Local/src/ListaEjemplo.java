import java.util.ArrayList;
import java.util.List;

public class ListaEjemplo {

	public static void main(String[] args) {
		List<String> ejemploLista = new ArrayList<String>();
	    ejemploLista.add("Juan");
	    ejemploLista.add("Pedro");
	    ejemploLista.add("Jos�");
	    ejemploLista.add("Mar�a");
	    ejemploLista.add("Sof�a");
	    System.out.println(ejemploLista.size());
	    System.out.println(ejemploLista.get(0));
	    ejemploLista.remove(0);
	    ejemploLista.remove("Pedro");
	    System.out.println(ejemploLista);
	    
	}

}
