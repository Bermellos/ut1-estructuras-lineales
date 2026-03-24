public class Producto 
{
    String nombre; 
    int precio; 
    String id; 
    static int contadorProductos; 

    public Producto(String nombre, int precio)
    {
        this.nombre = nombre; 
        this.precio = precio;
        contadorProductos+=1;
        this.id = "Producto" + contadorProductos; 
    }
}
