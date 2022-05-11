package com.example.ejercicio2.utils;

public class Utils {
    
    public static int[] contarLetras(String value) {
        int[] contadorLetras =  new int[2];
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i)=='a'|| value.charAt(i)=='e'|| value.charAt(i)=='i'|| value.charAt(i)=='o'|| value.charAt(i)=='u') {
                contadorVocales ++;
            }else {
                 contadorConsonantes ++;
            }
        }
        contadorLetras[0] = contadorVocales;
        contadorLetras[1] = contadorConsonantes;
        return contadorLetras;
    }  
    
    public static String cambiarPalabra(String palabra) {
        return palabra.toUpperCase();
    }
        
}
