
package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Archivo {
    
    private File archivo;
    private Scanner sc;
    private int[] arreglo;

    public int[] getArreglo(){
        return this.arreglo;
    }

    public Archivo(){
        try{
            this.archivo = new File("src\\main\\java\\com\\example\\numeros.txt");
            this.sc = new Scanner(archivo);
            int n = sc.nextInt();
            this.arreglo = new int[n];

            for(int i =0; i<this.arreglo.length;i++){
                arreglo[i]= sc.nextInt();   
            }
            sc.close();

        }catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        }
    }
    
}
