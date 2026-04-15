package com.example;

import java.io.File;
import java.util.Scanner;


public class ListaLibros
{
    public class Nodo
    {
        public Nodo siguiente;

        public Libros libro;

        public Nodo(Libros libro)
        {
            this.libro = libro;
            this.siguiente = null;
        }
    }

    Nodo primero;

    public ListaLibros()
    {
        this.primero = null;
    }

    public void incorporarLibro(Libros nuevoLibro)
    {
        Nodo nuevoNodo = new Nodo(nuevoLibro);

        nuevoNodo.siguiente = primero;

        primero = nuevoNodo;   // nuevoNodo ahora es el cabeza (el nuevo primero)

    }

    public void agregarEjemplares(String codigoLibro, int stockAgregar)
    {
        Nodo actual = primero;

        while (actual != null)
        {
            if (actual.libro.codigo.equals(codigoLibro))
            {
                actual.libro.stock += stockAgregar;
            }           

            actual = actual.siguiente;
        }
    }

    public void registrarPrestamo(String codigoLibro, int stockRestar)
    {
        Nodo actual = primero;

        while (actual != null)
        {
            if (actual.libro.codigo.equals(codigoLibro))
            {
                if (stockRestar > actual.libro.stock)
                {
                    stockRestar = actual.libro.stock; 
                    actual.libro.stock -= stockRestar;
                }
                else 
                {
                    actual.libro.stock -= stockRestar;
                }
            }

            actual = actual.siguiente;
        }
    }

    public void eliminarLibro(String codigoLibro)
    {
        Nodo actual = primero;

        if (primero.libro.codigo.equals(codigoLibro))
        {
           primero = primero.siguiente;  // si el primero es el que se quiere eliminar, entonces simplemente lo omito y paso al siguiente
        }

        while (actual.siguiente != null)  // comparo el siguiente, porque si comparo el actual no puedo hacer actual.siguiente, tendria que usar uno anterior
        {
            if (actual.siguiente.libro.codigo.equals(codigoLibro))  // comparo actual.siguiente con el codigo del libro
            {
                actual.siguiente = actual.siguiente.siguiente;  // salteo al que quiero eliminar
            }

            actual = actual.siguiente;  // sigo avanzando en el while
        }
    }

    public boolean verificarLibro(String codigoLibro)
    {
        Nodo actual = primero;

        while (actual != null)
        {
            if (actual.libro.codigo.equals(codigoLibro))
            {
                return true;  // devuelvo true si encuentro el código del libro
            }

            actual = actual.siguiente; // avanzo en el while
        }

        return false;  // si no encuentro el libro por su código, devuelvo false
    }

    public static void main(String args[]) throws Exception 
    {
        // SubGrupo A (PARTE 2)
        ListaLibros lista = new ListaLibros();
        
        int totalAgregado = 0; 

        Scanner archivo = new Scanner(new File("/src/main/resources/adquisiciones.txt"));

        while (archivo.hasNextLine())  // mientras el archivo siga teniendo lineas (renglones)
        {
            String linea = archivo.nextLine();  // creo una linea 

            String[] datos = linea.split(",");  // divido las lineas (0 sería el código, 1 el título, etc)

            String codigoTexto = datos[0].trim();  // .trim() elimina los espacios que hay al principio y al final 
            String tituloTexto = datos[1].trim(); 
            int precioTexto = Integer.parseInt(datos[2].trim()); 
            int stockTexto = Integer.parseInt(datos[3].trim()); 

            if (lista.verificarLibro(codigoTexto) == true)
            {
                lista.agregarEjemplares(codigoTexto, stockTexto);
            }

            else
            {
                Libros nuevoLibro = new Libros(tituloTexto, codigoTexto, precioTexto, stockTexto);

                lista.incorporarLibro(nuevoLibro);
            }

            totalAgregado += (precioTexto * stockTexto);
        } 

        archivo.close();

        System.out.println(totalAgregado);



        // SubGrupo B (PARTE 2) 
        Scanner archivo2 = new Scanner(new File("/src/main/resources/prestamos.txt"));

        int balanceTotal = 0;

        while (archivo2.hasNextLine())
        {
            String linea = archivo2.nextLine(); // es para leer, lee toda la línea completa 

            String[] datos = linea.split(",");

            String codigoTexto2 = datos[0];
            String estadoTexto2 = datos[1];
            int stockTexto2 = Integer.parseInt(datos[2]);

            if (estadoTexto2.equals("DEVOLUCION"))
            {
                lista.agregarEjemplares(codigoTexto2, stockTexto2);  // uso la misma lista para que los cambios se apliquen a la lista de libros original
                balanceTotal += stockTexto2; 
            }
            else if (estadoTexto2.equals("PRESTAMO"))
            {
                lista.registrarPrestamo(codigoTexto2, stockTexto2);
                balanceTotal -= stockTexto2; 
            }
        }

        archivo2.close();

        System.out.println(balanceTotal);


        // Integración y verificación (PARTE 3)
        System.out.println("LISTA FINAL DE LIBROS");

        Nodo actual = lista.primero; 

        while (actual != null)
        {
            System.out.println(actual.libro.codigo + actual.libro.titulo + actual.libro.precio + actual.libro.stock);

            actual = actual.siguiente; 
        }
    }
}


/* 
LN: Se pide que se cree un sistema de libros, los cuales deben quedar almacenados en una biblioteca (lista de libros). Dicho sistema debe permitir ingresar nuevos libros, reducir o aumentar el stock, verificar disponibilidad de un libro, listarlos todos por orden alfabético, registrar prestamos y devoluciones y eliminar libros del catálogo.

Precondiciones: El stock y el precio de un libro debe ser positivo y el título del libno y el nombre del autor no deben ser null.

Postcondiciones: Al agregar un libro al catálogo, se incrementa la cantidad de libros en la lista. Si el stock a restar es mayor al actual, debe restarse hasta donde se pueda.


Clase ListaLibros
    Clase Nodo
        Atributo Nodo siguiente

        Atributo Libros libro

        Constructor Nodo(Libros libro)
            this.libro <- libro
            this.siguiente <- null
        FinConstructor

    Atributo Nodo primero;

    Constructor ListaLibros()
        this.primero <- nulo
    FinConstructor

    Metodo incorporarLibro(Libros nuevoLibro)
        Nodo nuevoNodo <- new Nodo(nuevoLibro)

        nuevoNodo.siguiente <- primero
=
        primero <- nuevoNodo   // nuevoNodo ahora es el cabeza (el nuevo primero)

    FinMetodo

    Metodo agregarEjemplares(String codigoLibro, int stockAgregar)
        Nodo actual <- primero;

        Mientras (actual <> null)
            Si (actual.libro.codigo.equals(codigoLibro))
                actual.libro.stock += stockAgregar
            actual <- actual.siguiente;
        FinMientras
    FinMetodo

    Metodo registrarPrestamo(String codigoLibro, int stockRestar)
        Nodo actual = primero;

        Mientras (actual != null)
            Si (actual.libro.codigo.equals(codigoLibro))
                Si (stockRestar > actual.libro.stock)
                    stockRestar <- actual.libro.stock; 
                    actual.libro.stock -= stockRestar;
                SiNo 
                    actual.libro.stock -= stockRestar;
            SiNo

            actual = actual.siguiente;
        FinMientras
    FinMetodo

    Metodo eliminarLibro(String codigoLibro)
        Atributo Nodo actual <- primero

        Si (primero.libro.codigo.equals(codigoLibro))
           primero = primero.siguiente;  // si el primero es el que se quiere eliminar, entonces simplemente lo omito y paso al siguiente

        Mientras (actual.siguiente != null)  // comparo el siguiente, porque si comparo el actual no puedo hacer actual.siguiente, tendria que usar uno anterior
            Si (actual.siguiente.libro.codigo.equals(codigoLibro))  // comparo actual.siguiente con el codigo del libro
                actual.siguiente = actual.siguiente.siguiente;  // salteo al que quiero eliminar
            FinSi
            actual <- actual.siguiente;  // sigo avanzando en el while
        FinMientras
    FinMetodo

    Metodo verificarLibro(String codigoLibro)
        Atributo Nodo actual <- primero;

        Mientras (actual != null)
            Si (actual.libro.codigo.equals(codigoLibro))
                Devolver Verdadero  // devuelvo true si encuentro el código del libro
            FinSi

            actual <- actual.siguiente // avanzo en el while
        FinMientras

        Devolver Falso  // si no encuentro el libro por su código, devuelvo false
    }

    Metodo principal(String args[])  
    {
        // SubGrupo A (PARTE 2)
        Atributo ListaLibros lista <- new ListaLibros()
        
        Atributo int totalAgregado <- 0 

        Atributo Scanner archivo <- new Scanner(new File("/src/main/resources/adquisiciones.txt"))

        Mientras (archivo.hasNextLine())  // mientras el archivo siga teniendo lineas (renglones)
        {
            Atributo String linea = archivo.nextLine();  // creo una linea 

            Atributo String[] datos = linea.split(",");  // divido las lineas (0 sería el código, 1 el título, etc)

            Atributo String codigoTexto = datos[0].trim();  // .trim() elimina los espacios que hay al principio y al final 
            Atributo String tituloTexto = datos[1].trim(); 
            Atributo int precioTexto = Integer.parseInt(datos[2].trim()); 
            Atributo int stockTexto = Integer.parseInt(datos[3].trim()); 

            Si (lista.verificarLibro(codigoTexto) == Verdadero)
                lista.agregarEjemplares(codigoTexto, stockTexto)

            SiNo
                Libros nuevoLibro <- new Libros(tituloTexto, codigoTexto, precioTexto, stockTexto)

                lista.incorporarLibro(nuevoLibro)

            totalAgregado += (precioTexto * stockTexto);
        } 

        archivo.close()

        System.out.println(totalAgregado)



        // SubGrupo B (PARTE 2) 
        Atributo Scanner archivo2 = new Scanner(new File("/src/main/resources/prestamos.txt"))

        Atributo int balanceTotal = 0

        Mientras (archivo2.hasNextLine())
            Atributo String linea = archivo2.nextLine(); // es para leer, lee toda la línea completa 

            Atributo String[] datos = linea.split(",")

            Atributo String codigoTexto2 = datos[0];
            Atributo String estadoTexto2 = datos[1];
            Atributo int stockTexto2 = Integer.parseInt(datos[2]);

            Si (estadoTexto2.equals("DEVOLUCION"))
                lista.agregarEjemplares(codigoTexto2, stockTexto2);  // uso la misma lista para que los cambios se apliquen a la lista de libros original
                balanceTotal += stockTexto2; 
            FinSi
            SiNo Si (estadoTexto2.equals("PRESTAMO"))
                lista.registrarPrestamo(codigoTexto2, stockTexto2);
                balanceTotal -= stockTexto2; 
            FinSiNo
        FinMientras

        archivo2.close();

        System.out.println(balanceTotal);


        // Integración y verificación (PARTE 3)
        System.out.println("LISTA FINAL DE LIBROS");

        Nodo actual = lista.primero; 

        Mientras (actual <> nulo)
            System.out.println(actual.libro.codigo + actual.libro.titulo + actual.libro.precio + actual.libro.stock)
            actual = actual.siguiente
        FinMientras
    FinMientras
FinClase

*/