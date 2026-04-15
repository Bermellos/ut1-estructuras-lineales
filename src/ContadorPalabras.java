public class ContadorPalabras implements ProcesadorTexto 
{
    public int contarPalabras(String texto) // No puede ser static porque implementa una interfaz, lo mismo si hereda de una clase
    {
        int contador = 0; 
        texto = texto.trim();  // Remueve los espacios de los costados del string, no entre medio. 

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) == ' ')
            {
                contador++;
            }
        }
        if (texto.equals(""))
        {
            return 0;
        }

        return contador+1; 
    }

    public int contarPalabras(String[] lineas)
    {
        int total = 0;

        for (String linea: lineas)
        {
            total += contarPalabras(linea);
        }

        return total;
    }

    public static void main(String args[])
    {
        ContadorPalabras contar = new ContadorPalabras();
        int resultado = contar.contarPalabras("Hola Juan!");
        System.out.println("Texto: "+ resultado);

        ContadorPalabras cp = new ContadorPalabras();
        String[] lineas = {"Hola mundo", "Java es vida!"};
        System.out.println("Array: " + cp.contarPalabras(lineas));
    }
}
