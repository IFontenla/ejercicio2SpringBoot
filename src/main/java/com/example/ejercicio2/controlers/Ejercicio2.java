package com.example.ejercicio2.controlers;

import java.util.ArrayList;

import com.example.ejercicio2.models.Datos;
import com.example.ejercicio2.models.Traduccion;
import com.example.ejercicio2.services.DatoService;
import com.example.ejercicio2.services.TraductorService;
import com.example.ejercicio2.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ejercicio2 {

@Autowired
DatoService datoService; 

@Autowired
TraductorService traductorService;

    //http://localhost:8080/cambiarPalabra/BBBB
    @GetMapping("/cambiarPalabra/{cambioPalabra}")
    public String cambioPalabra(@PathVariable String cambioPalabra) {
        return Utils.cambiarPalabra(cambioPalabra);
    }

    //http://localhost:8080/contar/XXXX
    @GetMapping("/contar/{palabra}")
    public String contarLetras(@PathVariable String palabra) {
        int[] contarLetras = Utils.contarLetras(palabra);
        return "vocales :" + contarLetras[0] + " consonantes: " + contarLetras[1];
    }
    
    //http://localhost:8080/guarda?
    @GetMapping("/guarda")
    public String guarda(@RequestParam String dat1, @RequestParam String dat2, @RequestParam String dat3) {
        String[] datosUsuario = {dat1,dat2,dat3};
        
        for (int i=0; i<datosUsuario.length; i++) {
        Datos dato = new Datos();
        dato.setValue(datosUsuario[i]);
        datoService.saveDato(dato);
        }
        return"Los datos se han guardado correctamente";
    }

    //http://localhost:8080/listarDatos
    @GetMapping("/listarDatos")
    public String listaDatos() {
        ArrayList<Datos> datos = datoService.getAllDatos();
        String lista = "";
        for (Datos dato : datos) {
            lista += dato.getValue();
            lista += "<br/>";
        }
        return lista;
    }

    //http://localhost:8080/traduce/Hola que tal
    @GetMapping("/traduce/{parametro}")
        public String traduceParametro(@PathVariable String parametro) {
            Traduccion traduccion = traductorService.getTraduccionFromAPI(parametro);
        return traduccion.responseData.translatedText;
    }
}
