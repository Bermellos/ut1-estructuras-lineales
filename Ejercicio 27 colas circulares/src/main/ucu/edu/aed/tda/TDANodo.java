package ucu.edu.aed.tda;

	public class TDANodo<T>{
		private T dato;
		private TDANodo<T> siguiente;
		
		// Constructor
		public TDANodo(T dato) {
			this.dato = dato;
			this.siguiente = null;
		}
		
		// Getters
		public T getDato() { 
			return this.dato;
		}
		
		public TDANodo<T> getSiguiente() {
			return this.siguiente;
		}
		
		// Setters
		public void setDato(T dato) {
			this.dato = dato;
		}
		
		public void setSiguiente(TDANodo<T> siguiente) {
			this.siguiente = siguiente;
		}
	}
	
