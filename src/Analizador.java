public class Analizador 
{
    enum TipoCaracter 
    {
        VOCAL, CONSONANTE, DIGITO, OTRO  // Un enum sirve para seguridad de tipos y no inventar otro tipo que no esté dentro del enum
    }

    public TipoCaracter clasificar(char c)
    {
        char cNuevo = Character.toLowerCase(c); // Lo paso a mínuscula para que sea más facil; 

        if (cNuevo == 'a' || cNuevo == 'e' || cNuevo == 'i' || cNuevo == 'o' || cNuevo == 'u')  // Como es un char y no un String, no lo debo comparar con .equals() sino con == como hago con los enteros o boolean.
        {
            return TipoCaracter.VOCAL;
        }
        else if (Character.isLetter(cNuevo))
        {
            return TipoCaracter.CONSONANTE;
        }
        else if (Character.isDigit(cNuevo))
        {
            return TipoCaracter.DIGITO;
        }
        else
        {
            return TipoCaracter.OTRO;
        }

    }
    
}
