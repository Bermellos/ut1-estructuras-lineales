public class RecursividadMaximoArreglo 
{
    public static int maximo(int[] arr, int i)
    {
        if (arr.length-1 == i)  // Para que no se pase cuando hago i+1, sino da error
        {
            return arr[i];
        }
        else
        {
            int max = maximo(arr, i+1);  // Llamo a la función para ver si el primer número (arr[i]) es menor a arr[i+1] y los comparo con recursión. Luego retorno max
            if (max < arr[i])
            {
                max = arr[i];
            }
            return max;
        }
    }
    public static void main(String[] args)
    {
        int[] numeros = {5,3,2,8,1};
        System.out.println("El máximo es: " + maximo(numeros, 0));
    }   
}
