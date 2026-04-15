package ucu.edu.aed;

import ucu.edu.aed.tda.TDAConjunto;
import ucu.edu.aed.tda.TDALista;
import java.util.Comparator;
import java.util.function.Predicate;

public class Conjunto<T extends Comparable<T>> implements TDAConjunto<T> {

    private Nodo<T> cabeza;
    private int tamanio;

    public Conjunto() {
        cabeza = null;
        tamanio = 0;
    }

    @Override
    public int tamaño() {
        return tamanio;
    }

    @Override
    public boolean esVacio() {
        return tamanio == 0;
    }

    @Override
    public void vaciar() {
        cabeza = null;
        tamanio = 0;
    }

    @Override
    public boolean contiene(T elem) {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            if (temp.getDato().equals(elem)) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;

    }

    @Override
    public void agregar(T elem) {
        if (contiene(elem)) {
            return;
        }

        Nodo<T> nuevo = new Nodo<>(elem);

        if (cabeza == null || elem.compareTo(cabeza.getDato()) < 0) {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.getSiguiente() != null &&
                    elem.compareTo(temp.getSiguiente().getDato()) > 0) {
                temp = temp.getSiguiente();
            }
            nuevo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nuevo);
        }
        tamanio++;
    }

    @Override
    public T obtener(int index) {
        Nodo<T> temp = cabeza;
        for (int i = 0; i < index; i++) {
            temp = temp.getSiguiente();
        }
        return temp.getDato();
    }

    @Override
    public T remover(int index) {
        if (index == 0) {
            T dato = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return dato;
        }
        Nodo<T> temp = cabeza;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getSiguiente();
        }
        T dato = temp.getSiguiente().getDato();
        temp.setSiguiente(temp.getSiguiente().getSiguiente());
        tamanio--;
        return dato;
    }

    @Override
    public boolean remover(T elem) {
        if (cabeza == null)
            return false;
        if (cabeza.getDato().equals(elem)) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        Nodo<T> temp = cabeza;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getDato().equals(elem)) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                tamanio--;
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        Nodo<T> temp = cabeza;
        int index = 0;
        while (temp != null) {
            if (temp.getDato().equals(elem))
                return index;
            temp = temp.getSiguiente();
            index++;
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            if (criterio.test(temp.getDato()))
                return temp.getDato();
            temp = temp.getSiguiente();
        }
        return null;
    }

    @Override
    public void agregar(int index, T elem) {
        agregar(elem);
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparador) {
        return this;
    }



    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        Nodo<T> nodoA = this.cabeza;
        Nodo<T> nodoB = ((Conjunto<T>) otro).cabeza;

        while (nodoA != null && nodoB != null) {
            int cmp = nodoA.getDato().compareTo(nodoB.getDato());
            if (cmp < 0) {
                resultado.agregarAlFinal(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
            } else if (cmp > 0) {
                resultado.agregarAlFinal(nodoB.getDato());
                nodoB = nodoB.getSiguiente();
            } else {
                resultado.agregarAlFinal(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            }
        }
        while (nodoA != null) {
            resultado.agregarAlFinal(nodoA.getDato());
            nodoA = nodoA.getSiguiente();
        }
        while (nodoB != null) {
            resultado.agregarAlFinal(nodoB.getDato());
            nodoB = nodoB.getSiguiente();
        }
        return resultado;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        Nodo<T> nodoA = this.cabeza;
        Nodo<T> nodoB = ((Conjunto<T>) otro).cabeza;

        while (nodoA != null && nodoB != null) {
            int cmp = nodoA.getDato().compareTo(nodoB.getDato());
            if (cmp < 0) {
                nodoA = nodoA.getSiguiente();
            } else if (cmp > 0) {
                nodoB = nodoB.getSiguiente();
            } else {
                resultado.agregarAlFinal(nodoA.getDato());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            }
        }
        return resultado;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        return null;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        return false;
    }

    private void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        tamanio++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Nodo<T> temp = cabeza;
        while (temp != null) {
            sb.append(temp.getDato());
            if (temp.getSiguiente() != null) sb.append(", ");
            temp = temp.getSiguiente();
        }
        sb.append("}");
        return sb.toString();
    }

}