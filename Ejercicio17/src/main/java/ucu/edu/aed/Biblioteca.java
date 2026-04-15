package ucu.edu.aed;

public class Biblioteca {

    private ListaEnlazada<Libro> libros;

    public Biblioteca(){
        this.libros = new ListaEnlazada<Libro>();
    }

    public void agregarLibro(Libro libro){

        if (buscarPorCodigo(libro.getIsbn()) == null){
            this.libros.agregar(libro);
        }     
    }

    public void eliminarLibro(String isbn){
        
        Libro libro = buscarPorCodigo(isbn);

        /*Se asume que la baja del libro no ocurre automáticamente por stock, 
        es una desición tomada por el usuario que hace uso del sistema*/
        
        if (libro!=null){
            this.libros.eliminar(libro);
        }
    }

    public boolean prestarLibro (String isbn, int cant){
        Libro libro = buscarPorCodigo(isbn);
        boolean hayEjemplar = true;

        if (libro!=null && libro.getEjemplares()>=cant ){
            libro.reducirEjemplar (cant);
            hayEjemplar = true;
        }else{
            hayEjemplar= false;
        }
        return hayEjemplar;
    }

    public void devolverLibro (String isbn, int cant){

        Libro libro = buscarPorCodigo(isbn);

        if (libro!=null){
            libro.agregarEjemplar(cant);
        }
    }

    public Libro buscarPorCodigo(String isbn){
        return this.libros.buscar(l -> l.getIsbn() == isbn);
    }

    public void agregarEjemplares(String isbn, int cant){
        devolverLibro(isbn, cant);
    }

    public String mostrarLibrosOrdenados() {

        StringBuilder sb = new StringBuilder();
        sb.append("(");

        libros.ordenar((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));

        Nodo<Libro> actual = libros.getCabeza();
        while (actual != null) {
            Libro l = actual.getDato();
            sb.append("Nombre: " + l.getNombre() + " | Stock: " + l.getEjemplares());
            
            actual = actual.getSiguiente();
            if (actual != null){
                sb.append(",");
            }  
        }
        sb.append(")");

        return sb.toString();
    }

    public boolean estaVacia(){
        return this.libros.estaVacia();
    }
}

