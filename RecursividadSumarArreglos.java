public class RecursividadSumarArreglos 
{
    public static int sumarArreglos(int[] arr, int i)
    {
        if (i == arr.length)
        {
            return 0;
        }
        else
        {
            return arr[i] + sumarArreglos(arr, i+1); 
        }
    }    
    public static void main(String[] args)
    {
        int[] numeros = {5,10,15};
        System.out.println("El total es: " + sumarArreglos(numeros, 0));
    }
}