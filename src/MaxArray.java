public class MaxArray 
{
    public static int maximo(int[] a)
    {
        int max = a[0];

        for (int i = 0; i < a.length; i++)
        {
            if (max < a[i])
            {
                max = a[i];
            }
        }

        return max;
    }
    
    public static void main(String args[])
    {
        int[] a = {12, 45, 9, 22, 5};

        int resultado = maximo(a);
        System.out.println(resultado);
    }
}
