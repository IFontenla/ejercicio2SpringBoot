package com.example.ejercicio2.repositories;

import org.springframework.stereotype.Repository;
import com.example.ejercicio2.models.Datos;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DatoRepository extends CrudRepository<Datos, Long>{
    
}
