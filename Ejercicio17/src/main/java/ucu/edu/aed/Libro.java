package ucu.edu.aed;

public class Libro {

    private String isbn;
    private String nombre;
    private double precio;
    private short cantidadEjemplares; 

    public Libro(String isbn, double precio, short cantidadEjemplares, String nombre){
        this.isbn = isbn;
        this.precio = precio;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombre = nombre;
    }

    public void agregarEjemplar(int cant){
        if(cant>0){
            this.cantidadEjemplares += cant;
        }
        else{
            return;
        }
        
    }
    public void reducirEjemplar(int cant){
        if(cant>0){
            this.cantidadEjemplares -= cant;
        }
        else{
            return;
        }
    }

    public String getIsbn(){
        return this.isbn;
    }

    public int getEjemplares(){
        return this.cantidadEjemplares;
    }

    public void cambiarPrecio(double precio){
        if(precio>0){
            this.precio = precio;
        }
        else{
            return;
        }
    }

    public String getNombre(){
        return this.nombre;
    }

}

