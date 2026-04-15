## **Parte1:** 
Se solicita desarrollar un sistema para gestionar los libros de la Biblioteca Central UCU. El sistema deberá almacenar los libros en una lista, donde cada libro tendrá título, código de identificación, precio de reposición y cantidad de ejemplares disponibles. Cada libro se identificará de forma única por su código, lo que permitirá realizar búsquedas y operaciones sobre él. El sistema deberá permitir agregar nuevos libros al catálogo, aumentar o disminuir la cantidad de ejemplares, registrar préstamos y devoluciones (validando disponibilidad), eliminar libros que ya no circulan, consultar el stock de un libro por su código y listar todos los libros ordenados alfabéticamente por título junto con su stock. La implementación deberá utilizar un TDA Lista para almacenar los libros, y se deberán definir las clases Biblioteca y Libro con las responsabilidades correspondientes.

**Precondiciones:** <br/>
- El titulo de un libro nuevo a agregar al catálogo debe ser único y no debe existir previamente en el catálogo
- El título del libro no debe ser nulo ni vacío
- El precio de reposición debe ser positivo
- La cantidad de ejemplares de un libro tiene que ser un número positivo
- Para registrar un préstamo o devolución hay que asegurarse que el libro está presente en el catálogo
- Para ordenar los libros tiene que haber al menos uno

**Postcondiciones:** <br/>
- Al agregar un nuevo libro tiene que aparecer en el catálogo, tiene que aumentar el catálogo y la cantidad de ese libro tiene que ser positiva
- En el caso de un préstamo, la cantidad de ejemplares disponibles disminuye en la cantidad prestada
- En el caso de una devolución, la cantidad de ejemplares disponibles se incrementa en la cantidad devuelta
- Al retirar libros de circulación se eliminan del catálogo y el tamaño del catálogo se reduce
- Al buscar un libro por código, si el libro no se encontró o la cantidad es 0, se devuelve un mensaje indicativo


## **Parte2:**

```
    METODO agregarLibro(libro)
        SI buscarPorCodigo(libro.isbn) = NULL ENTONCES
            libros.agregar(libro)
        FIN SI
    FIN METODO

    METODO eliminarLibro(isbn)
        libro ← buscarPorCodigo(isbn)

        SI libro ≠ NULL ENTONCES
            libros.eliminar(libro)
        FIN SI
    FIN METODO

    METODO prestarLibro(isbn, cant) : boolean
        libro ← buscarPorCodigo(isbn)

        SI libro ≠ NULL Y libro.ejemplares ≥ cant ENTONCES
            libro.reducirEjemplar(cant)
            RETORNAR VERDADERO
        SINO
            RETORNAR FALSO
        FIN SI
    FIN METODO

    METODO devolverLibro(isbn, cant)
        libro ← buscarPorCodigo(isbn)

        SI libro ≠ NULL ENTONCES
            libro.agregarEjemplar(cant)
        FIN SI
    FIN METODO

    METODO buscarPorCodigo(isbn) : Libro
        RETORNAR libros.buscar( función(l) → l.isbn = isbn )
    FIN METODO

    METODO agregarEjemplares(isbn, cant)
        devolverLibro(isbn, cant)
    FIN METODO

    METODO mostrarLibrosOrdenados() : String
        sb ← "("

        libros.ordenar( función(a, b) → compararNombre(a, b) )

        actual ← libros.cabeza

        MIENTRAS actual ≠ NULL HACER
            l ← actual.dato
            sb ← sb + "Nombre: " + l.nombre + " | Stock: " + l.ejemplares

            actual ← actual.siguiente

            SI actual ≠ NULL ENTONCES
                sb ← sb + ","
            FIN SI
        FIN MIENTRAS

        sb ← sb + ")"

        RETORNAR sb
    FIN METODO

    METODO estaVacia() : boolean
        RETORNAR libros.estaVacia()
    FIN METODO
```
