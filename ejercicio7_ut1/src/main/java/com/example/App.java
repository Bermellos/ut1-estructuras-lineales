package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Contador contador = new Contador();
        contador.Recorre();
        System.out.println(contador.getLargoArreglo());
        System.out.println(contador.getAcumulador());
        System.out.println(contador.getIntercambio());
        contador.PrimerUltimoElemento();

    }
}
