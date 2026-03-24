public class ListaLibrosArray 
{
    public Libro listalibros[] = new Libro[100];
    public int cantidadActual = 0;

    public void agregarLibro(Libro nuevoLibro)
    {
        if (cantidadActual < listalibros.length)
        {
            listalibros[cantidadActual] = nuevoLibro; 
            cantidadActual++;
        }
    }

    public int buscarLibro(String codigoUsuario)
    {
        for (int i = 0; i < cantidadActual; i++)
        {
            if (listalibros[i].codigo.equals(codigoUsuario))
            {
                return i;
            }
        }
        return -1;
    }

    public void sumarStock(String codigoUsuario, int cantidad)
    {
        int indice = buscarLibro(codigoUsuario);  // Para no tener que hacer de nuevo for y buscar el libro 

        if (indice != -1)
        {
            listalibros[indice].stock += cantidad; 
        }
    }

    public void restarStock(String codigoUsuario, int cantidad)
    {
        int indice = buscarLibro(codigoUsuario);   // Para no tener que hacer de nuevo for y buscar el libro 

        if (indice != -1)
        {
            listalibros[indice].stock -= cantidad; 
        }
    }
    
}
