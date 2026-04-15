package ucu.edu.aed;

import java.util.function.Predicate;
import java.util.Comparator;

public class ListaEnlazada<T> implements TDALista<T>{

    private Nodo<T> cabeza;
    

    public ListaEnlazada(){
        cabeza = null;
    }


    @Override
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);

        if(cabeza == null){
            cabeza = nuevo;
        }else{
            Nodo<T> temp = cabeza;
            while (temp.getSiguiente() !=null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        
        Nodo<T> temp = cabeza;

        while (temp !=null) {
            if(criterio.test(temp.getDato())){
                return temp.getDato();
            }
            temp= temp.getSiguiente();
        }
        return null;
    }

    @Override
    public void eliminar(T dato) {
        
        if (cabeza == null) return;

        if (cabeza.getDato().equals(dato)){
            cabeza = cabeza.getSiguiente();
            return;
        }
        
        Nodo <T> temp = cabeza;

        while (temp.getSiguiente()!=null){
            if(temp.getSiguiente().getDato().equals(dato)){
                Nodo <T> actual = temp.getSiguiente();
                temp.setSiguiente(actual.getSiguiente());
                return;
            }
            temp= temp.getSiguiente();
        }    
    }

    @Override
    public void ordenar(Comparator<T> comp) {
        if (cabeza == null) return;

        Nodo<T> actual = cabeza;

        while (actual != null) {
            Nodo<T> menor = actual;
            Nodo<T> temp = actual.getSiguiente();

            while (temp != null) {
                if (comp.compare(temp.getDato(), menor.getDato()) < 0) {
                    menor = temp;
                }
                temp = temp.getSiguiente();
            }

            T aux = actual.getDato();
            actual.setDato(menor.getDato());
            menor.setDato(aux);

            actual = actual.getSiguiente();
        }
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }
    
    @Override
    public boolean estaVacia() {
        return cabeza == null;
    }
    
}

