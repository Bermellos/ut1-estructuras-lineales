package com.example;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ListaLibrosTest
{
    @Test 
    public void deberiaAgregarLibro()
    {
        ListaLibros lista = new ListaLibros();  // creo lista de libros

        Libro libro1 = new Libro("100 años de soledad","123425-A", 2000, 249);  // creo libro1
        Libro libro2 = new Libro("Don Quijote de la Mancha","132443-N", 1570, 362);  // creo libro2

        lista.incorporarNuevoLibro(libro1); // agrego libro1 a la lista
        lista.incorporarNuevoLibro(libro2);  // agrego libro2 a la lista

        assertEquals("Don Quijote de la Mancha", lista.primero.libro.titulo);  // Primero libro2 porque el primero que entra va a quedar después del siguiente que entra
        assertEquals("100 años de soledad", lista.primero.siguiente.libro.titulo);  // lista.primero porque entro al vagón primero y agrego un titulo y primero.siguiente para entrar al siguiente
    }

    @Test 
    public void deberiaBuscarLibro()
    {
        ListaLibros lista = new ListaLibros();  // creo lista de libros 

        Libro libro = new Libro("100 años de soledad","123425-A", 2000, 249);  // creo libro

        lista.incorporarNuevoLibro(libro);  // agrego libro a la lista

        assertEquals("100 años de soledad", lista.buscarLibro("123425-A").libro.titulo);  // Comparo el objeto creado recién con nombre "100 años de soledad" con el título del libro a ver si son iguales (los liibros se buscan por el código del mismo).
    }

    @Test 
    public void deberiaAgregarStock()
    {
        ListaLibros lista = new ListaLibros();  // creo lista de libros

        Libro libro = new Libro("100 años de soledad", "123425-A", 2000, 249); // creo libro

        lista.incorporarNuevoLibro(libro);  // agrego libro a la lista

        lista.agregarStock("123425-A", 100);  // se lo sumo al objeto

        assertEquals(349, libro.stock);  // lo comparo directamente con libro.stock porque no puedo compararlo con el método al ser void
    }

    @Test 
    public void deberiaRestarStock()
    {
        ListaLibros lista = new ListaLibros();  // creo lista de libros

        Libro libro = new Libro("100 años de soledad", "123425-A", 2000, 249); // creo libro

        lista.incorporarNuevoLibro(libro);  // agrego libro a la lista

        lista.restarStock("123425-A", 249);  // se lo resto al objeto

        assertEquals(149, libro.stock);  // lo comparo directamente con libro.stock porque no puedo compararlo con el método al ser void
    }
}
