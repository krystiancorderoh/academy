class Gen<T>{
    //T es el par�metro de tipo gen�rico.
    T ob; //Declara un objeto de tipo T
    //Pase al constructor una referencia a un objeto de tipo T.
    Gen(T o)	{
        ob=o;	}
    T getOb()		{
        return ob;	}
    //Muestra el tipo de T
    void mostrarTipo()														{
        System.out.println("El tipo de T es: "+ob.getClass().getName());    }
}