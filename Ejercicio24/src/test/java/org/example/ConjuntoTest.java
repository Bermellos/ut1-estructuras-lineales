package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ucu.edu.aed.Conjunto;
import ucu.edu.aed.TAlumno;
import ucu.edu.aed.tda.TDAConjunto;

public class ConjuntoTest {

    @Test
    public void testUnionConjuntosDisjuntos() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        a.agregar(new TAlumno(1002, "Ana", "Garcia"));
        b.agregar(new TAlumno(1003, "Luis", "Lopez"));

        TDAConjunto<TAlumno> resultado = a.union(b);

        assertEquals(3, resultado.tamaño());
        assertTrue(resultado.contiene(new TAlumno(1001, "x", "x")));
        assertTrue(resultado.contiene(new TAlumno(1002, "x", "x")));
        assertTrue(resultado.contiene(new TAlumno(1003, "x", "x")));
    }

    @Test
    public void testUnionConElementosComunes() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        TAlumno comun = new TAlumno(1002, "Ana", "Garcia");
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        a.agregar(comun);
        b.agregar(comun);
        b.agregar(new TAlumno(1003, "Luis", "Lopez"));

        TDAConjunto<TAlumno> resultado = a.union(b);

        assertEquals(3, resultado.tamaño());
        assertTrue(resultado.contiene(comun));
    }

    @Test
    public void testUnionConConjuntoVacio() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> vacio = new Conjunto<>();
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        a.agregar(new TAlumno(1002, "Ana", "Garcia"));

        TDAConjunto<TAlumno> resultado = a.union(vacio);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene(new TAlumno(1001, "x", "x")));
        assertTrue(resultado.contiene(new TAlumno(1002, "x", "x")));
    }

    @Test
    public void testUnionDosVacios() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();

        TDAConjunto<TAlumno> resultado = a.union(b);

        assertTrue(resultado.esVacio());
    }

    @Test
    public void testUnionConjuntosIguales() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        b.agregar(new TAlumno(1001, "Juan", "Perez"));

        TDAConjunto<TAlumno> resultado = a.union(b);

        assertEquals(1, resultado.tamaño());
    }

    @Test
    public void testInterseccionConjuntosDisjuntos() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        b.agregar(new TAlumno(1002, "Ana", "Garcia"));

        TDAConjunto<TAlumno> resultado = a.interseccion(b);

        assertTrue(resultado.esVacio());
    }

    @Test
    public void testInterseccionConElementosComunes() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        TAlumno comun = new TAlumno(1002, "Ana", "Garcia");
        a.agregar(new TAlumno(1001, "Juan", "Perez"));
        a.agregar(comun);
        b.agregar(comun);
        b.agregar(new TAlumno(1003, "Luis", "Lopez"));

        TDAConjunto<TAlumno> resultado = a.interseccion(b);

        assertEquals(1, resultado.tamaño());
        assertTrue(resultado.contiene(comun));
    }

    @Test
    public void testInterseccionConConjuntoVacio() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> vacio = new Conjunto<>();
        a.agregar(new TAlumno(1001, "Juan", "Perez"));

        TDAConjunto<TAlumno> resultado = a.interseccion(vacio);

        assertTrue(resultado.esVacio());
    }

    @Test
    public void testInterseccionConjuntosIguales() {
        Conjunto<TAlumno> a = new Conjunto<>();
        Conjunto<TAlumno> b = new Conjunto<>();
        TAlumno alumno = new TAlumno(1001, "Juan", "Perez");
        a.agregar(alumno);
        b.agregar(alumno);

        TDAConjunto<TAlumno> resultado = a.interseccion(b);

        assertEquals(1, resultado.tamaño());
        assertTrue(resultado.contiene(alumno));
    }
}
