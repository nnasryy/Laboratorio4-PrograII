/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prograii;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jc1st
 */
public class AdminPalabrasSecretas {
    private ArrayList<String> listaDePalabras = new ArrayList<>();
    private Random randomizar;

    public AdminPalabrasSecretas() {
        this.listaDePalabras=new ArrayList<>();
        this.randomizar = new Random();
    }
    
    public boolean agregarPalabra(String palabra){
        if(palabra == null || palabra.trim().isEmpty()){
            return false;
        }
        
        String palabraNueva = palabra.toUpperCase().trim();
        
        if(!listaDePalabras.contains(palabraNueva)){
            listaDePalabras.add(palabraNueva);
            return true;
    }
        return false;
    }
    
    public String obtenerPalabraRandom(){
        if(listaDePalabras.isEmpty()){
            return null;
        }
        
        int indiceDePalabra = randomizar.nextInt(listaDePalabras.size());
        return listaDePalabras.get(indiceDePalabra);
    }
}    
