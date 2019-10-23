import java.util.Scanner;

public class EnteroABinario {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un numero ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println(enteroABinario(num));

	}

	public static String enteroABinario(int entero) {
		if(entero == 0)
			return "0";
		else if(entero == 1)
			return "1";
		else
			return	enteroABinario(entero/2)+""+(entero%2);
	}
}
