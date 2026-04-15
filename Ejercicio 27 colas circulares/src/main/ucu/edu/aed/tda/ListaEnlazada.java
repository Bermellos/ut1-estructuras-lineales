package ucu.edu.aed.tda;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
	protected TDANodo<T> primero;
	private int tamaño;

	// Constructor
	public ListaEnlazada() {
		this.primero = null;
		this.tamaño = 0;
	}

	@Override
	public void agregar(T elem) {
		if (primero == null) {
			primero = new TDANodo<>(elem);
		} else {
			TDANodo<T> actual = primero;
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(new TDANodo<>(elem));
		}
		tamaño++;
	}

	@Override
	public void agregar(int index, T elem) {
		if (index < 0 || index > tamaño) {
			throw new IndexOutOfBoundsException("Índice fuera de rango");
		}

		if (index == 0) {
			TDANodo<T> nuevoNodo = new TDANodo<>(elem);
			nuevoNodo.setSiguiente(primero);
			primero = nuevoNodo;
		} else {
			TDANodo<T> actual = primero;
			for (int i = 0; i < index - 1; i++) {
				actual = actual.getSiguiente();
			}
			TDANodo<T> nuevoNodo = new TDANodo<>(elem);
			nuevoNodo.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(nuevoNodo);
		}
		tamaño++;
	}

	@Override
	public T obtener(int index) {
		if (index < 0 || index >= tamaño) {
			throw new IndexOutOfBoundsException("Índice fuera de rango");
		}

		TDANodo<T> actual = primero;
		for (int i = 0; i < index; i++) {
			actual = actual.getSiguiente();
		}
		return actual.getDato();
	}

	@Override
	public T remover(int index) {
		if (index < 0 || index >= tamaño) {
			throw new IndexOutOfBoundsException("Índice fuera de rango");
		}

		T dato;
		if (index == 0) {
			dato = primero.getDato();
			primero = primero.getSiguiente();
		} else {
			TDANodo<T> actual = primero;
			for (int i = 0; i < index - 1; i++) {
				actual = actual.getSiguiente();
			}
			dato = actual.getSiguiente().getDato();
			actual.setSiguiente(actual.getSiguiente().getSiguiente());
		}
		tamaño--;
		return dato;
	}

	@Override
	public boolean remover(T elem) {
		if (primero == null) {
			return false;
		}

		if (primero.getDato().equals(elem)) {
			primero = primero.getSiguiente();
			tamaño--;
			return true;
		}

		TDANodo<T> actual = primero;
		while (actual.getSiguiente() != null) {
			if (actual.getSiguiente().getDato().equals(elem)) {
				actual.setSiguiente(actual.getSiguiente().getSiguiente());
				tamaño--;
				return true;
			}
			actual = actual.getSiguiente();
		}
		return false;
	}

	@Override
	public boolean contiene(T elem) {
		TDANodo<T> actual = primero;
		while (actual != null) {
			if (actual.getDato().equals(elem)) {
				return true;
			}
			actual = actual.getSiguiente();
		}
		return false;
	}

	@Override
	public int indiceDe(T elem) {
		TDANodo<T> actual = primero;
		int index = 0;
		while (actual != null) {
			if (actual.getDato().equals(elem)) {
				return index;
			}
			actual = actual.getSiguiente();
			index++;
		}
		return -1;
	}

	@Override
	public T buscar(Predicate<T> criterio) {
		TDANodo<T> actual = primero;
		while (actual != null) {
			if (criterio.test(actual.getDato())) {
				return actual.getDato();
			}
			actual = actual.getSiguiente();
		}
		return null;
	}

	@Override
	public TDALista<T> ordenar(Comparator<T> comparator) {
		ListaEnlazada<T> listaOrdenada = new ListaEnlazada<>();
		
		// Copia todos los elementos
		TDANodo<T> actual = primero;
		while (actual != null) {
			listaOrdenada.agregar(actual.getDato());
			actual = actual.getSiguiente();
		}

		// Ordena usando bubble sort
		for (int i = 0; i < listaOrdenada.tamaño - 1; i++) {
			for (int j = 0; j < listaOrdenada.tamaño - i - 1; j++) {
				if (comparator.compare(listaOrdenada.obtener(j), 
				                       listaOrdenada.obtener(j + 1)) > 0) {
					// Intercambia elementos
					T temp = listaOrdenada.obtener(j);
					listaOrdenada.remover(j);
					listaOrdenada.agregar(j, listaOrdenada.obtener(j));
					listaOrdenada.remover(j + 1);
					listaOrdenada.agregar(j + 1, temp);
				}
			}
		}
		return listaOrdenada;
	}

	@Override
	public int tamaño() {
		return tamaño;
	}

	@Override
	public boolean esVacio() {
		return tamaño == 0;
	}

	@Override
	public void vaciar() {
		primero = null;
		tamaño = 0;
	}
}

	
