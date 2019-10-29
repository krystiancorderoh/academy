class Genericos {
    public static void main(String[] args) {
    	Gen<Integer> iOb;  //Crea una referencia Gen para Integers.
        //Cree un objeto Gen<Integer> y asigne su referencia a iOb.
        //Observe el uso de autoboxing para encapsular el valor 28 dentro 
    	//de un objeto Integer.
        iOb=new Gen<Integer>(28);
        iOb.mostrarTipo(); //Muestra el tipo de dato utilizado por iOb
        //Obtenga el valor en iOb.
        //F�jese que no se necesita una conversi�n
        int v=iOb.getOb();
        System.out.println("Valor: "+v);
        System.out.println();
        //Cree un objeto Gen para Strings.
        Gen<String> strOb=new Gen<String>("Prueba de gen�ricos");
        strOb.mostrarTipo();//Muestra el tipo de dato utilizado por strOb
        //Obtenga el valor de strOb.
        // De nuevo, note que no se necesita de conversi�n
        String str=strOb.getOb();
        System.out.println("Valor: "+str);    }}