package ucu.edu.aed;

import ucu.edu.aed.tda.TDAConjunto;

public class Main {

    public static void main(String[] args) {

        Conjunto<TAlumno> aed1 = new Conjunto<>();
        Conjunto<TAlumno> pf = new Conjunto<>();

        TAlumno alumno1 = new TAlumno(1001, "Juan",   "Perez");
        TAlumno alumno2 = new TAlumno(1002, "Ana",    "Garcia");
        TAlumno alumno3 = new TAlumno(1003, "Luis",   "Lopez");
        TAlumno alumno4 = new TAlumno(1004, "Maria",  "Martinez");
        TAlumno alumno5 = new TAlumno(1005, "Carlos", "Fernandez");
        TAlumno alumno6 = new TAlumno(1006, "Sofia",  "Rodriguez");

        aed1.agregar(alumno1);
        aed1.agregar(alumno2);
        aed1.agregar(alumno3);
        aed1.agregar(alumno4);

        pf.agregar(alumno2);
        pf.agregar(alumno3);
        pf.agregar(alumno5);
        pf.agregar(alumno6);

        System.out.println("Curso AED1:");
        System.out.println(aed1);

        System.out.println("\nCurso Programacion Funcional:");
        System.out.println(pf);

        TDAConjunto<TAlumno> union = aed1.union(pf);
        System.out.println("\nAlumnos matriculados en cualquiera de los dos cursos:");
        System.out.println(union);

        TDAConjunto<TAlumno> interseccion = aed1.interseccion(pf);
        System.out.println("\nAlumnos matriculados en ambos cursos:");
        System.out.println(interseccion);
    }
}
