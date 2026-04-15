package com;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

import com.example.Expresion; 

public class ExpresionTest 
{
    @Test 
    public void controlCorchetesDeberiaFuncionarCorrectamente()
    {
        List<Character> listaDeEntrada = new ArrayList<Character>();  // Arrange 
        listaDeEntrada.add('{');
        listaDeEntrada.add('}');
        Expresion expresion = new Expresion(); 
        
        boolean resultado = expresion.controlCorchetes(listaDeEntrada);  // Act

        Assert.assertTrue(resultado);  // Assert 

    }
    
}