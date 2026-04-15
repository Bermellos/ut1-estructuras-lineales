package ucu.edu.aed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestionPrestamos {

    public void obtenerLineas(Biblioteca biblioteca){
        //String path = "D:\\UCU 2025\\UCU 2026\\AED\\RepoEquipo\\proyecto-ej17-TA1\\src\\main\\resources\\prestamos.txt";
        int variacionCantidad = 0;
        InputStream is = getClass().getClassLoader().getResourceAsStream("prestamos.txt");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String linea= null;            
            
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");

                String isbn = partes[0].trim();
                String tipo = partes[1].trim();
                short cantidad = Short.parseShort(partes[2].trim());

                Libro libro = biblioteca.buscarPorCodigo(isbn);
                

                if (libro != null){
                    int antes = libro.getEjemplares();
                    
                    if (tipo.equalsIgnoreCase("prestamo")){
                        biblioteca.prestarLibro(isbn, cantidad);
                        variacionCantidad = (antes -= libro.getEjemplares() );
                    }
                    else if(tipo.equalsIgnoreCase("devolucion")){
                        biblioteca.devolverLibro(isbn, cantidad);
                        variacionCantidad += cantidad;
                    }
                    else{
                        continue;
                    }
                }else{
                    continue;
                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
