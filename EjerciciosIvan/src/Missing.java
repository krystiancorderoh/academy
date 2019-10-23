
public class Missing {

	public static void main(String[] args) {
		
		int[] numeros = {0,8,4,2,6,1,5,9};
		int temp = 0;
		boolean banderaDuplicados= false;
		
		//Ordenar el arreglo
		for(int j=1; j< numeros.length; j++) {
			for(int i=0;i < (numeros.length-1); i++) {
				if(numeros[i]==numeros[i+1]) {
					banderaDuplicados= true;
					System.out.println("El arreglo contiene numeros duplicados");
					break;
				}
				if(numeros[i]>numeros[i+1]) {
					
					temp = numeros[i];
					numeros[i] = numeros[i+1];
					numeros[i+1] = temp;
				}
			}
			if(banderaDuplicados) {
				break;
			}
		}
		
		//buscar faltantes
		
		int iteraciones=0;
		for(int j=1; j< (numeros.length-1); j++) {
			
			
			
			if((numeros[j]+1)!= numeros[j+1]) {
				iteraciones =numeros[j+1]-numeros[j];
				for(int i = 1; i < iteraciones; i++) {
					System.out.println(numeros[j]+i);
				}
				
			}
			
		}
		
		
	}
}
