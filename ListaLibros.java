public class ListaLibros 
{

    public class Nodo
    {
        public Libro libro; 
        public Nodo siguiente;
        
        public Nodo (Libro libro)  // Nodo siguiente no va en el constructor porque siempre lo inicializamos en null
        {
            this.libro = libro; 
            this.siguiente = null; // Lo inicializo en null porque no sé quien viene después, siempre hay que hacer esto 
        }

    }

    public Nodo primero; 

    public ListaLibros()
    {
        this.primero = null; 
    }

    public void incorporarNuevoLibro(Libro nuevoLibro)  // nuevoLibro de tipo Libro
    {
        Nodo agregarLibro = new Nodo(nuevoLibro);
        agregarLibro.siguiente = primero; 
        primero = agregarLibro;  // Intercambia lugar con primero y pasa a estar antes agregarLibro, osea lo pongo al inicio y primero queda despues
    }

    public Nodo buscarLibro(String codigoUsuario)
    {
        Nodo actual = primero; 

        while (actual != null)
        {
            if (actual.libro.codigo.equals(codigoUsuario))
            {
                return actual; 
            }

            actual = actual.siguiente; 
        }

        return null; 
    }

    public void agregarStock(String codigoUsuario, int cantidad)
    {
        Nodo nodo = buscarLibro(codigoUsuario);

        if (nodo != null)
        {
            nodo.libro.stock += cantidad; 
        }
    }

    public void restarStock(String codigoUsuario, int cantidad)
    {
        Nodo nodo = buscarLibro(codigoUsuario);

        if (nodo != null && cantidad <= nodo.libro.stock)
        {
            nodo.libro.stock -= cantidad; 
        }
    }
    
}


/* 
-Descripción en LN: El algoritmo inserta un libro al principio de una lista enlazada y lo incorpora al catálogo de una biblioteca. Para esto, conecta el nuevo nodo con el que era el primer elemento actual y luego actualiza la referencia primero para que el nuevo libro sea la nueva cabeza de la lista.

-Precondiciones: El objeto nuevoLibro no debe ser null, tiene titulo y codigo. La lista debe estar inicializada con el puntero primero (inicializada en null) y luego primero debe ser accesible.

-Postcondiciones: El nuevoLibro se agrega correctamente en la primera posisción de la lista. El tamaño de la lista se incrementó en uno.


-Pseudocódigo detallado: 

Clase Nodo
    Atributos:
        libro: Libro
        siguiente: Nodo
    
    Constructor(nuevoLibro)
        libro <- nuevoLibro
        siguiente <- nulo
Fin Clase

Clase ListaLibros
    Atributos:
        primero: Nodo

    Constructor()
        primero <- nulo
    Fin Constructor


    Procedimiento incorporarNuevoLibro(nuevoLibro: Libro)  // Procedimiento para incorporar nuevoLibro
        nuevoNodo <- crear Nodo(nuevoLibro)   // Crear un nuevo nodo con el libro recibido
        nuevoNodo.siguiente <- primero   // Apuntar el brazo 'siguiente' del nuevo nodo al actual primer nodo
        primero <- nuevoNodo   // Actualizar "primero" para que ahora apunte al nuevo nodo
    Fin Procedimiento

    Función buscarLibro(codigoUsuario: Cadena) : Nodo 
        actual <- primero
        Mientras actual <> nulo Hacer
            Si actual.libro.codigo == codigoUsuario Entonces
                Retornar actual
            Fin Si
            actual <- actual.siguiente
        Fin Mientras
        Retornar nulo
    Fin Función

    Procedimiento agregarStock(codigoUsuario: Cadena, cantidad: Entero)
        nodoEncontrado <- buscarLibro(codigoUsuario)
        Si nodoEncontrado <> nulo Entonces
            nodoEncontrado.libro.stock <- nodoEncontrado.libro.stock + cantidad
        Fin Si
    Fin Procedimiento

    Procedimiento restarStock(codigoUsuario: Cadena, cantidad: Entero)
        nodoEncontrado <- buscarLibro(codigoUsuario)
        Si nodoEncontrado <> nulo Y cantidad <= nodoEncontrado.libro.stock Entonces
            nodoEncontrado.libro.stock <- nodoEncontrado.libro.stock - cantidad
        Fin Si
    Fin Procedimiento

Fin Clase

*/