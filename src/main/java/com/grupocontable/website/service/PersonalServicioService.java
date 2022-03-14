package com.grupocontable.website.service;

import com.grupocontable.website.model.PersonalCapacitacion;
import com.grupocontable.website.model.PersonalServicio;
import com.grupocontable.website.repository.PersonalCapacitacionRepository;
import com.grupocontable.website.repository.PersonalServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServicioService {

    private final PersonalServicioRepository personalServicioRepository;

    public PersonalServicioService(PersonalServicioRepository personalServicioRepository) {
        this.personalServicioRepository = personalServicioRepository;
    }

    public List<PersonalServicio> listar (){
        return personalServicioRepository.findAll();
    }

    public PersonalServicio obtenerPersonalServicio(Integer id){
        return personalServicioRepository.findById(id).get();
    }

    public void agregarPersonalServicio(PersonalServicio personalServicio
    ){
        personalServicioRepository.save(personalServicio);
    }

    public void eliminarPersonalServicio(Integer id){
        personalServicioRepository.deleteById(id);
    }
}
