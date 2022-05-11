package com.example.ejercicio2.services;

import java.util.ArrayList;

import com.example.ejercicio2.models.Datos;
import com.example.ejercicio2.repositories.DatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatoService {
    @Autowired
    DatoRepository datoRepository;

    public Datos saveDato(Datos dato) {
        Datos newDato = datoRepository.save(dato);
        return newDato;
    }
    
    public ArrayList<Datos> getAllDatos() {
        ArrayList<Datos> datos = (ArrayList<Datos>)datoRepository.findAll();
        return datos;
    }
}
