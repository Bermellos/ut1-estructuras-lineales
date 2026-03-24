public class Palindromo 
{
    public String texto;

    public Palindromo(String texto)
    {
        this.texto = texto; 
    }

    public boolean esPalindromo()
    {
        String texto_limpio = this.texto.toLowerCase().replaceAll("[^a-zA-Z]", "");  // El replaceAll("[^a-zA-Z]", "") borra todo lo que NO sea (^) una letra.
        String texto_invertido = new StringBuilder(texto_limpio).reverse().toString(); // Invertimos usando StringBuilder (versión de string mutable, que si se puede cambiar).

        return texto_invertido.equals(texto_limpio);
    }
    
    public static void main(String args[])
    {
        Palindromo palindromo1 = new Palindromo("Anita lava la tina");
        Palindromo palindromo2 = new Palindromo("Did Hannah see bees? Hannah did");

        System.out.println(palindromo1.esPalindromo());
        System.out.println(palindromo2.esPalindromo());
    }
}
