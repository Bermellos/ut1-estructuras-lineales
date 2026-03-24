public class EstudianteListaArray 
{
    public EstudianteArray estudiantes[] = new EstudianteArray[100];
    public int cantidadEstudiantes = 0; // 0 al inicio 

    public void agregarEstudiante(EstudianteArray nuevoEstudiante)
    {
        if (cantidadEstudiantes < estudiantes.length) // Verifico para no pasarme del largo del array, por si no entran mas estudiantes
        {
            estudiantes[cantidadEstudiantes] = nuevoEstudiante; // Arranca en 0, después incremento y pasa a ser 1 y así hasta llegar a 100 (max del array)
            cantidadEstudiantes++;
        }
    }

    public void actualizarNota(String idUsuario, double nuevaNota)
    {
        for (int i = 0; i < cantidadEstudiantes; i++)
        {
            if (estudiantes[i].id.equals(idUsuario))
            {
                estudiantes[i].nota = nuevaNota; 
            }
        }
    }

    public double calcularPromedio()
    {
        double suma = 0; 

        for (int i = 0; i < cantidadEstudiantes; i++)
        {
            suma += estudiantes[i].nota;
        }

        double promedio = suma / cantidadEstudiantes; 

        return promedio; 
    }

    public void mostrarTodosEstudiantes()
    {
        for (int i = 0; i < cantidadEstudiantes; i++) 
        {
            System.out.println(estudiantes[i].nota + " - " + estudiantes[i].id);
        } 
    }

}