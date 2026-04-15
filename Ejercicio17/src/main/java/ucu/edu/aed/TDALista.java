package ucu.edu.aed;

import java.util.Comparator;
import java.util.function.Predicate;

public interface TDALista <T> {
    void agregar(T dato);
    T buscar (Predicate<T> criterio);
    void eliminar (T dato);
    boolean estaVacia();
    void ordenar(Comparator<T> comp);    
}
