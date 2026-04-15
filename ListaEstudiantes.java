public class ListaEstudiantes 
{
    public class Nodo
    {
        public Nodo siguiente; 
        public Estudiante estudiante; 

        public Nodo(Estudiante estudiante)
        {
            this.estudiante = estudiante; 
            this.siguiente = null; 
        }
        
    }

    public Nodo primero; 

    public ListaEstudiantes()
    {
        this.primero = null; 
    }

    public void agregarEstudiante(Estudiante nuevoEstudiante)
    {
        Nodo nuevoNodo = new Nodo(nuevoEstudiante);
        nuevoNodo.siguiente = primero; // nuevoNodo apunta ahora a primero
        primero = nuevoNodo;  // primero apunta a nuevoNodo. nuevoNodo queda al inicio
    }

    public Nodo buscarEstudiante(String cedulaUsuario)
    {
        Nodo actual = primero; 

        while (actual != null)
        {
            if (actual.estudiante.cedula.equals(cedulaUsuario))
            {
                return actual;
            }

            actual = actual.siguiente; // Para que avance 
        }

        return null; 
    }

    public void subirPromedio(String cedulaUsuario, double puntos)
    {
        Nodo nodo = buscarEstudiante(cedulaUsuario);

        if (nodo != null)
        {
            nodo.estudiante.promedio += puntos; 
        }
    }

    public void bajarPromedio(String cedulaUsuario, double puntos)
    {
        Nodo nodo = buscarEstudiante(cedulaUsuario);

        if (nodo != null && nodo.estudiante.promedio >= puntos)
        {
            nodo.estudiante.promedio -= puntos; 
        }
    }

    public Nodo promedioBueno(String cedulaUsuario)
    {
        Nodo nodo = buscarEstudiante(cedulaUsuario);

        if (nodo != null && nodo.estudiante.promedio > 8.0)
        {
            return nodo; 
        }
        else
        {
            return null; 
        }
    }

    public void mostrarTodos()
    {
        Nodo actual = primero; 

        while (actual != null)
        {
            System.out.println(actual.estudiante.cedula + actual.estudiante.nombre + actual.estudiante.promedio);

            actual = actual.siguiente; 
        }
    }
    
}
