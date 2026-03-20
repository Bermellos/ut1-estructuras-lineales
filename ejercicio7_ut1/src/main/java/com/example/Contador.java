package com.example;

public class Contador {

    
    private int[] arreglo;
    private int acumulador;
    private int intercambio;

    public Contador(){
        Archivo archivo = new Archivo();
        this.arreglo = archivo.getArreglo();
        this.acumulador = 0;
        this.intercambio = 0;
    }

    public void Recorre(){
        int n = arreglo.length;

        for(int i =1; i<n; i++){
            for (int j = n-1; j >= i; j--){
                this.acumulador++;
                if(arreglo[j]< arreglo[j-1]){
                    Intercambia(j, j-1);
                    this.intercambio++;
                }
            }
        }
    }

    public void Intercambia(int a, int b){
        int temp = arreglo[a];
        this.arreglo[a] = this.arreglo[b];
        this.arreglo[b] = temp;    

    }

    public int[] getArreglo(){
        return arreglo;
    }

    public int getLargoArreglo(){
        return this.arreglo.length;
    }
    public int getAcumulador(){
        return this.acumulador;
    }

    public int getIntercambio(){
        return this.intercambio;
    }

    public void PrimerUltimoElemento(){
        System.out.println("El primer elemento del arreglo es " + this.arreglo[0] + 
        " y el ultimo es "+ this.arreglo[getLargoArreglo()-1]);
    }
}


/*
Desde i = 1 hasta N-1 hacer
 Desde j = N hasta i+1 hacer
 Si arreglo[j] < arreglo[j-1] entonces
 Intercambia(arreglo[j], arreglo[j-1])
 FinSi
 FinDesde
FinDesde

*/