package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList; 
import java.util.Scanner; 

public class GestionSucursales 
{
    public LinkedList<String> lista;

    public GestionSucursales()
    {
        this.lista = new LinkedList<>();  
    }

    public void agregarSucursal(String sucursal)
    {
        lista.add(sucursal);  // Complejidad O(1)
    }

    public boolean buscarSucursal(String sucursal)  // Complejidad O(n) ya que para buscarla tiene que recorrer toda la lista 
    {
        return lista.contains(sucursal);   // sucursal es un objeto (es String, que es una clase con objetos)
    }

    public void quitarSucursal(String sucursal)
    {
        lista.remove(sucursal);   // Complejidad O(n), ya que tiene que ir recorriendo hasta encontrarla 
    }

    public void listarSucursales()
    {
        for (String s: lista)  // Complejidad O(n)  ---> recorre toda la lista 
        {
            System.out.println(s);  // No hay una función de LinkedList que liste todas las sucursales, por lo que recorro la lista manualmente con un for-each
        }
    }

    public int cantidadSucursales() // Complejidad O(1)
    {
        return lista.size();  // Devuelve un int la función size
    }

    public boolean estaVacio() // Complejidad O(1)
    {
        return lista.isEmpty();  // Devuelve true o false dependiendo si la lista está vacía (no tiene sucursales)
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        GestionSucursales gestion = new GestionSucursales();

        Scanner archivo = new Scanner(new File("ejercicio17/src/main/java/com/example/suc1.txt"));
        Scanner archivo2 = new Scanner(new File("ejercicio17/src/main/java/com/example/suc2.txt"));
        Scanner archivo3 = new Scanner(new File("ejercicio17/src/main/java/com/example/suc3.txt"));
        
        
        // suc1.txt
        while (archivo.hasNextLine())
        {
            String ciudad = archivo.nextLine(); // Cada línea del archivo es una ciudad
            gestion.agregarSucursal(ciudad);
        }

        archivo.close();

        System.out.println(gestion.cantidadSucursales());  // 107 sucursales 

        gestion.quitarSucursal("Chicago");

        System.out.println(gestion.cantidadSucursales());  // Eliminamos a Chicago de la lista enlazada (el anterior y el siguiente se "toman la mano"), entonces la que le sigue es Shenzen
        
        gestion.lista.clear(); // Sirve para borrar todo lo que hay en la lista (así puedo agregar cosas del segundo archivo)

        

        
        // suc2.txt
        while (archivo2.hasNextLine())  // Recorro archivo2 (suc2.txt)
        {
            String ciudad2 = archivo2.nextLine(); // Cada línea del archivo es una ciudad
            gestion.agregarSucursal(ciudad2);
        }

        gestion.quitarSucursal("Shenzen"); // Shenzen no existe, pero no pasa nada porque no da error si eliminas algo que no existe
        gestion.quitarSucursal("Tokio"); // Elimino Tokio (el único elemento de suc2.txt) 

        gestion.lista.clear(); // Sirve para borrar todo lo que hay en la lista (así puedo agregar cosas del tercer archivo)

        

        
        // suc3.txt
        while (archivo3.hasNextLine()) // Recorro archivo3 (suc3.txt)
        {
            String ciudad3 = archivo3.nextLine(); // Cada línea del archivo es una ciudad
            gestion.agregarSucursal(ciudad3);
        }

        // es la opción 4 y no la 2 porque siempre después de cada ciudad va un ";"
        
    }
}
