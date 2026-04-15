package ucu.edu.aed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GestionAdquisiciones {

    public void obtenerLineas(Biblioteca biblioteca){
        //String path = "D:\\UCU 2025\\UCU 2026\\AED\\RepoEquipo\\proyecto-ej17-TA1\\src\\main\\resources\\adquisiciones.txt";

        InputStream is = getClass().getClassLoader().getResourceAsStream("adquisiciones.txt");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String linea= null;
            
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");

                String isbn = partes[0].trim();
                String titulo = partes[1].trim();
                double precio = Double.parseDouble(partes[2].trim());
                short cantidad = Short.parseShort(partes[3].trim());

                Libro libro = biblioteca.buscarPorCodigo(isbn);

                if(libro == null){
                    Libro libroN = new Libro(isbn, precio, cantidad, titulo);
                    biblioteca.agregarLibro(libroN);
                }
                else{
                    for(int i = 0; i <cantidad; i++){
                        libro.agregarEjemplar(cantidad);
                    }
                }

            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}

