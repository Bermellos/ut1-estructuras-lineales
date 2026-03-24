public class RecursividadSuma 
{
    public static int suma (int n) 
    {
        if (n == 0) 
        {
            return 0; 
        }
        else
        {
          return n + suma(n-1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("La suma de los primeros 5 numeros es: " + suma(5));
    }
    
}
