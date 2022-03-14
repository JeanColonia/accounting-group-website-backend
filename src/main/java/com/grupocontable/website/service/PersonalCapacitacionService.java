package com.grupocontable.website.service;

import com.grupocontable.website.model.Personal;
import com.grupocontable.website.model.PersonalCapacitacion;
import com.grupocontable.website.repository.PersonalCapacitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalCapacitacionService {

    private final PersonalCapacitacionRepository personalCapacitacionRepository;

    public PersonalCapacitacionService(PersonalCapacitacionRepository personalCapacitacionRepository) {
        this.personalCapacitacionRepository = personalCapacitacionRepository;
    }

    public List<PersonalCapacitacion> listar (){
        return personalCapacitacionRepository.findAll();
    }

    public PersonalCapacitacion obtenerPersonalCapacitacion(Integer id){
        return personalCapacitacionRepository.findById(id).get();
    }

    public void agregarPersonalCapacitacion(PersonalCapacitacion personalCapacitacion){
        personalCapacitacionRepository.save(personalCapacitacion);
    }

    public void eliminarPersonalCapacitacion(Integer id){
        personalCapacitacionRepository.deleteById(id);
    }
}
