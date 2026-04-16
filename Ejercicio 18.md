# Ejercicio 18 

lenguaje natural

1. Quitar un elemento: remover un nodo de la lista y devolverlo, permitiendo su reutilización posterior

2. Eliminar un elemento: consiste en remover un nodo de la lista y descartarlo definitivamente

Ambas operaciones deben localizar el elemento a partir de una clave, actualizar correctamente los enlaces de la lista y contemplar casos especiales como lista vacía o eliminación del primer nodo


Precondiciones

- La lista debe estar inicializada (puede estar vacía)
- La clave del elemento a buscar no debe ser nula
- La estructura de la lista debe ser válida (sin ciclos y correctamente encadenada)

Postcondiciones

Operación: Quitar

Si el elemento existe:

Se elimina de la lista
Se devuelve el nodo eliminado
El campo siguiente del nodo eliminado se establece en null
si el elemento no existe:

 La lista permanece sin cambios
 
 Se devuelve null


Operación: Eliminar

Si el elemento existe:

Se elimina de la lista
Se devuelve true

Si el elemento no existe:

La lista permanece sin cambios
Se devuelve false



# Seudocódigo – Quitar elemento

función quitar(clave)

    si primero = null entonces
        devolver null
    fin si

    actual <- primero
    anterior <- null

    mientras actual != null hacer

        si actual.clave = clave entonces

            si anterior = null entonces
                primero <- actual.siguiente
            sino
                anterior.siguiente <- actual.siguiente
            fin si

            actual.siguiente <- null
            devolver actual

        fin si

        anterior <- actual
        actual <- actual.siguiente

    fin mientras

    devolver null

fin función



# Seudocódigo – Eliminar elemento

función eliminar(clave)

    si primero = null entonces
        devolver false
    fin si

    actual <- primero
    anterior <- null

    mientras actual != null hacer

        si actual.clave = clave entonces

            si anterior = null entonces
                primero <- actual.siguiente
            sino
                anterior.siguiente <- actual.siguiente
            fin si

            devolver true

        fin si

        anterior <- actual
        actual <- actual.siguiente

    fin mientras

    devolver false

fin función





# Otros comportamientos posibles

* Quitar el primer elemento
* Quitar el último elemento
* Vaciar la lista
