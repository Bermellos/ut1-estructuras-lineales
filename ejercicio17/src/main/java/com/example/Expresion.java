import java.util.List;
import java.util.Stack;

public class Expresion 
{
    public boolean controlCorchetes(List<Character> listaDeEntrada)  // paso por parámetro la lista
    {
        Stack <Character> pila = new Stack<>(); // creo el stack dentro del método, sino sería atributo

        for (char caracter: listaDeEntrada)
        {
            if (caracter == '{')
            {
                pila.push(caracter); 
            }

            else if (caracter == '}')
            {
                if (pila.isEmpty())  // si viene uno de cierre y la pila está vacía está mal, no puedo hacer pop a algo que no está, ya no hay nada
                {
                    return false; 
                }

                else 
                {
                    pila.pop();

                }
            }
        }

        return pila.isEmpty(); // si queda algo en la pila da falso y sino da verdadero 
    }
    
}