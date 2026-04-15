package ucu.edu.aed.tda;

/**
 * Implementación de TDACola usando un vector circular.
 *
 * @param <T> el tipo de los elementos almacenados en la cola
 */
public class ColaCircular<T> implements TDACola<T> {

    private Object[] elementos;
    private int frente;
    private int fin;
    private int tamaño;
    private int capacidad;

    /**
     * Constructor que inicializa la cola con una capacidad dada.
     *
     * @param capacidad la capacidad inicial del vector
     */
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    /**
     * Constructor por defecto con capacidad 10.
     */
    public ColaCircular() {
        this(10);
    }

    @Override
    public T frente() {
        if (esVacio()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return (T) elementos[frente];
    }

    @Override
    public boolean poneEnCola(T dato) {
        if (tamaño == capacidad) {
            // Para simplificar, no expandimos, solo retornamos false
            return false;
        }
        fin = (fin + 1) % capacidad;
        elementos[fin] = dato;
        tamaño++;
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (esVacio()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        T dato = (T) elementos[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return dato;
    }

    @Override
    public boolean esVacio() {
        return tamaño == 0;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public void agregar(T dato) {
        poneEnCola(dato);
    }

    @Override
    public void agregar(int indice, T dato) {
        // No implementado para cola
        throw new UnsupportedOperationException("Agregar en índice no soportado en cola");
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        int pos = (frente + indice) % capacidad;
        return (T) elementos[pos];
    }

    @Override
    public T remover(int indice) {
        // No implementado para cola
        throw new UnsupportedOperationException("Remover por índice no soportado en cola");
    }

    @Override
    public boolean remover(T elem) {
        // No implementado para cola
        throw new UnsupportedOperationException("Remover elemento no soportado en cola");
    }

    @Override
    public boolean contiene(T elem) {
        for (int i = 0; i < tamaño; i++) {
            int pos = (frente + i) % capacidad;
            if (elementos[pos].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        for (int i = 0; i < tamaño; i++) {
            int pos = (frente + i) % capacidad;
            if (elementos[pos].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T buscar(java.util.function.Predicate<T> criterio) {
        for (int i = 0; i < tamaño; i++) {
            int pos = (frente + i) % capacidad;
            T elem = (T) elementos[pos];
            if (criterio.test(elem)) {
                return elem;
            }
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(java.util.Comparator<T> comparator) {
        // No implementado para cola
        throw new UnsupportedOperationException("Ordenar no soportado en cola");
    }

    @Override
    public void vaciar() {
        frente = 0;
        fin = -1;
        tamaño = 0;
    }
}