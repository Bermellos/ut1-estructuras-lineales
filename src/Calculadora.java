public class Calculadora 
{
    public static int sumar(int a, int b)
    {
        return a + b;
    }

    public static double sumar(double a, double b)
    {
        return a + b;
    }

    public static int sumar(int a, int b, int c)
    {
        return a + b + c;
    }

    public static void main(String args[])
    {
        System.out.println(sumar(1,2));
        System.out.println(sumar(1.0,2.0));
        System.out.println(sumar(1,2, 3));
    }
    
}
