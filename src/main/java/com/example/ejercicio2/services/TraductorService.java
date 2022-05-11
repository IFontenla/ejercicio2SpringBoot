package com.example.ejercicio2.services;

import com.example.ejercicio2.models.Traduccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TraductorService {
    @Autowired
    RestTemplate restTemplate;

    public Traduccion getTraduccionFromAPI(String parametro) {
        String url = "https://api.mymemory.translated.net/get?q=" + parametro + "&langpair=es|en" ;
        Traduccion traduccion = restTemplate.getForObject(url, Traduccion.class);
        return traduccion;
    }
}