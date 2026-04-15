package com.example;

import java.util.Stack; 
import java.util.List; 

public class Expresion 
{
    public boolean controlCorchetes(List<Character> listaDeEntrada)
    {
        Stack<Character> pila = new Stack<>();

        for (char caracter: listaDeEntrada)
        {
            if (caracter == '{')
            {
                pila.push(caracter);
            }

            else if (caracter == '}')
            {
                if (pila.isEmpty())
                {
                    return false; // si la pila está vacía y hay un } significa que está mal, no se puede hacer pop si no hay nada 
                }

                else 
                {
                    pila.pop();
                }
            }
        }

        return pila.isEmpty();  // si la pila está vacía significa que la secuencia es correcta, se cerró (}) todo lo que se abrió ({)
    }

    public static void main(String args[])
    {
        Expresion prueba = new Expresion();

        List<Character> lista = List.of('{', '{', '}', '}');

        boolean resultado = prueba.controlCorchetes(lista);

        System.out.println("¿Es válida la expresión? " + resultado);
    }
}