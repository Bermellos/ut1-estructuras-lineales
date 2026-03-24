public class RecursividadFactorial // Clase principal del programa
{

    public static int factorial (int n) // Método recursivo para calcular el factorial de un número
    {
        if (n == 0) 
        {
            return 1; // Para saber cuanto es factorial(n) debo saber cuanto es factorial(n-1) y así sucesivamente hasta llegar a factorial(0) que es igual a 1 porque te lo dice el return entonces factorial(0) siempre es 1  
        }
        else 
        {
            return n * factorial(n - 1);
        }
    }
    public static void main(String[] args) // Método principal donde comienza la ejecución del programa
    {   
        System.out.println("El factorial de 5 es: " + factorial(5)); // Imprime el resultado del factorial de 5
    }   
}