package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ucu.edu.aed.*;

public class AppTest {

    private Biblioteca crearBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("978-1", 20.0, (short) 3, "Zebra"));
        biblioteca.agregarLibro(new Libro("978-3", 15.0, (short) 2, "Manzana"));
        biblioteca.agregarLibro(new Libro("978-5", 10.0, (short) 5, "Banana"));
        biblioteca.agregarLibro(new Libro("978-4", 25.0, (short) 1, "Naranja"));
        biblioteca.agregarLibro(new Libro("978-2", 30.0, (short) 4, "Cereza"));
        return biblioteca;
    }

    @Test
    public void testListarOrdenado() {
        Biblioteca biblioteca = crearBiblioteca();
        String resultado = biblioteca.mostrarLibrosOrdenados();
        assertTrue(resultado.indexOf("Banana") < resultado.indexOf("Cereza"));
        assertTrue(resultado.indexOf("Cereza") < resultado.indexOf("Manzana"));
        assertTrue(resultado.indexOf("Manzana") < resultado.indexOf("Naranja"));
        assertTrue(resultado.indexOf("Naranja") < resultado.indexOf("Zebra"));
    }

    @Test
    public void testEliminarLibro() {
        Biblioteca biblioteca = crearBiblioteca();
        biblioteca.eliminarLibro("978-5"); // elimina Banana
        assertNull(biblioteca.buscarPorCodigo("978-5"));
    }

    @Test
    public void testBuscarLibro() {
        Biblioteca biblioteca = crearBiblioteca();
        Libro libro = biblioteca.buscarPorCodigo("978-3"); // busca Manzana
        assertNotNull(libro);
        assertEquals("Manzana", libro.getNombre());
    }

    @Test
    public void testNoEstaVacia() {
        Biblioteca biblioteca = crearBiblioteca();
        assertNotNull(biblioteca.buscarPorCodigo("978-5"));
    }

    @Test
    public void testCargarAdquisicionesYOrdenar() {
        Biblioteca biblioteca = crearBiblioteca();
        GestionAdquisiciones gestion = new GestionAdquisiciones();
        gestion.obtenerLineas(biblioteca);
        String resultado = biblioteca.mostrarLibrosOrdenados();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Nombre:"));
    }

    @Test
    public void testPrestarConTxt() {
        Biblioteca biblioteca = crearBiblioteca();
        GestionPrestamos prestamos = new GestionPrestamos();
        prestamos.obtenerLineas(biblioteca);
        String resultado = biblioteca.mostrarLibrosOrdenados();
        assertNotNull(resultado);
    }

    @Test
    public void testPrestarMasDelStock() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("978-1", 10.0, (short) 2, "Banana"));
        biblioteca.prestarLibro("978-1", 10); // pide 10, solo hay 2
        assertTrue(biblioteca.buscarPorCodigo("978-1").getEjemplares() >= 0);
    }

}