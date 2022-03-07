package com.grupocontable.website.service;

import com.grupocontable.website.model.Personal;
import com.grupocontable.website.repository.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {
    private final PersonalRepository personalRepository;

    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public List<Personal> listarPersonal(){
        return personalRepository.findAll();
    }

    public Personal obtenerPersonal(Integer id){
        return personalRepository.findById(id).get();
    }

    public void guardarPersonal(Personal personal){
        personalRepository.save(personal);
    }

    public void eliminarPersonal(Integer idPersonal){
        personalRepository.deleteById(idPersonal);
    }

}
