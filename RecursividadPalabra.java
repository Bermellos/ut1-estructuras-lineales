public class RecursividadPalabra 
{
    public static String invertir(String palabra)
    {
        if (palabra.length() == 0)
        {
            return palabra;
        }
        else
        {
            return invertir(palabra.substring(1)) + palabra.charAt(0);
        }
    }
    public static void main(String[] args)
        {
            System.out.println("La palabra invertida de 'HOLA' es: " + invertir("HOLA"));
        }
}