public class Arrays 
{
    public static int[] interseccion(int[] a, int[] b)
    {
        int[] resultado = new int[a.length];
        int indice_resultado = 0;

        for (int i = 0; i < a.length; i++) // Como es un array, length va sin (). Si fuera un String ahí si length()
        {
            for (int j = 0; j < b.length; j++)
            {
                if (a[i] == b[j])
                {
                    resultado[indice_resultado] = a[i];
                    indice_resultado++; 
                }

            }
        }

        return resultado;
    }

    public static void main(String args[])
    {

        int[] a = {1,2,3,4,5};
        int[] b = {3,4,5,6,7};

        int[] resultado = interseccion(a,b);

        for (int i = 0; i < resultado.length; i++)
        {
            System.out.println(resultado[i]);
        }
    }
    
}
