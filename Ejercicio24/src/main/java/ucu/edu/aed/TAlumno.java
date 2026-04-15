package ucu.edu.aed;

public class TAlumno implements Comparable<TAlumno> {
    private int cedula;
    private String nombre;
    private String apellido;

    public TAlumno(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getcedula() {
        return this.cedula;
    }

    public String getnombre() {
        return this.nombre;
    }

    public String getapellido() {
        return this.apellido;
    }

    @Override
    public int compareTo(TAlumno otro) {
        return Integer.compare(this.cedula, otro.cedula);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TAlumno))
            return false;
        TAlumno otro = (TAlumno) o;
        return this.cedula == otro.cedula;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " (" + cedula + ")";
    }

}
