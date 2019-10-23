
public class cuentaPalabras {

	public static void main(String[] args) {
		
		String cadena = "   Hello World asd asdf  jj  ";
		int contador = 0;
		int indice = 0;
		
		for(int j = 0; j < cadena.length(); j++) {
			
			if(cadena.charAt(j) == ' ' ) {
				
				if (j>0) {
					
					if(cadena.charAt(j-1) != ' ') {
								contador++;
					}
				}
			}
			indice=j;
		}
		if (cadena.charAt(indice)!=' ') {
			contador++;
		}
		
		System.out.print(contador);

	}

}
