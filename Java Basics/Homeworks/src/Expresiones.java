import java.util.regex.Pattern;

public class Expresiones {

	public static void main(String[] args) {
		String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";

		// Lo siguiente devuelve true
		System.out.println(Pattern.matches(regexp, "11/12/2014"));
		System.out.println(Pattern.matches(regexp, "1/12/2014"));
		System.out.println(Pattern.matches(regexp, "11/2/2014"));


		// Los siguientes devuelven false
		System.out.println(Pattern.matches(regexp, "11/12/14"));  // El año no tiene cuatro cifras
		System.out.println(Pattern.matches(regexp, "11//2014"));  // el mes no tiene una o dos cifras
		System.out.println(Pattern.matches(regexp, "11/12/14perico"));  // Sobra "perico"
	}

}
