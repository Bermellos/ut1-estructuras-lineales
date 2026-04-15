# COLAS CIRCULARES

## Especificación en lenguaje natural
Una cola circular es una estructura de datos que implementa una cola FIFO usando un vector de tamaño fijo, donde los índices se "envuelven" al final del vector para reutilizar el espacio.

## Pre y postcondiciones
- **Pre:** La cola está implementada con un vector de capacidad fija.
- **Post:** Las operaciones mantienen la integridad de la cola circular.

## Pseudocódigo para PoneEnCola(unElemento)

```
Procedimiento PoneEnCola(cola: ColaCircular, unElemento: T)
    Si cola.tamaño == cola.capacidad entonces
        // Cola llena, no se puede agregar
        Retornar falso
    FinSi

    cola.fin ← (cola.fin + 1) MOD cola.capacidad
    cola.elementos[cola.fin] ← unElemento
    cola.tamaño ← cola.tamaño + 1
    Retornar verdadero
FinProcedimiento
```

## Pseudocódigo para QuitaDeCola()

```
Función QuitaDeCola(cola: ColaCircular): T
    Si cola.tamaño == 0 entonces
        // Cola vacía, error
        Lanzar excepción "Cola vacía"
    FinSi

    elemento ← cola.elementos[cola.frente]
    cola.frente ← (cola.frente + 1) MOD cola.capacidad
    cola.tamaño ← cola.tamaño - 1
    Retornar elemento
FinFunción
```

## Casos de prueba
- Agregar elementos hasta llenar la cola.
- Quitar elementos y verificar el orden FIFO.
- Agregar después de quitar para probar la circularidad.
| Caso | A | B | Resultado esperado |
|------|---|---|-------------------|
| Ambas vacías | [] | [] | [] |
| A vacía | [] | [2,4] | [2,4] |
| B vacía | [1,3] | [] | [1,3] |
| Sin intersección | [1,3,5] | [2,4,6] | [1,2,3,4,5,6] |
| Intersección parcial | [1,2,4] | [2,3,4] | [1,2,3,4] |
| Idénticas | [1,2,3] | [1,2,3] | [1,2,3] |
| A contiene a B | [1,2,3,4] | [2,4] | [1,2,3,4] |

## Análisis de complejidad
Cada elemento de A y B es visitado a lo sumo una vez → el bucle principal hace a lo sumo n + m iteraciones.

`agregar(T)` al final de una lista enlazada es O(1) si se mantiene puntero a cola, o O(n) con lista simple; `obtener(i)` en lista enlazada es O(i).

Con lista enlazada sin acceso aleatorio directo, `obtener(i)` cuesta O(i), y se llama n+m veces → O(n² + m²) en el peor caso con lista enlazada.

Con lista basada en arreglo (ArrayList), `obtener(i)` es O(1) → O(n + m).

# INTERSECCIÓN

## Especificación en lenguaje natural
Dadas dos listas ordenadas que representan conjuntos, la intersección produce una nueva lista ordenada que contiene únicamente los elementos presentes en ambas listas.

## Pre y postcondiciones
- **Pre:** A y B son listas ordenadas (por el mismo criterio) y sin elementos duplicados.
- **Post:** Se retorna una nueva lista C ordenada, sin duplicados, que contiene exactamente los elementos que pertenecen a A y a B simultáneamente.

## Pseudocódigo
```
Función interseccion(A: Lista<T>, B: Lista<T>): Lista<T>
    C ← nueva Lista vacía
    i ← 0
    j ← 0

    Mientras i < A.tamaño() Y j < B.tamaño() hacer
        a ← A.obtener(i)
        b ← B.obtener(j)

        Si a < b entonces
            i ← i + 1          // a no puede estar en B, avanzar A
        SiNo Si a > b entonces
            j ← j + 1          // b no puede estar en A, avanzar B
        SiNo                   // a == b, elemento común
            C.agregar(a)
            i ← i + 1
            j ← j + 1
        FinSi
    FinMientras

    Retornar C
FinFunción
```

## Casos de prueba
| Caso | A | B | Resultado esperado |
|------|---|---|-------------------|
| Ambas vacías | [] | [] | [] |
| A vacía | [] | [1,2] | [] |
| Sin elementos comunes | [1,3,5] | [2,4,6] | [] |
| Intersección parcial | [1,2,4] | [2,3,4] | [2,4] |
| Idénticas | [1,2,3] | [1,2,3] | [1,2,3] |
| B subconjunto de A | [1,2,3,4] | [2,4] | [2,4] |

## Análisis de complejidad
Igual al de unión — O(n + m) con arreglo, O(n² + m²) con lista enlazada por el costo de `obtener(i)`.