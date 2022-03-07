package com.grupocontable.website.service;

import com.grupocontable.website.model.Publicacion;
import com.grupocontable.website.repository.PublicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {
    private final PublicacionRepository publicacionRepository;

    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public List<Publicacion> listar(){
        return publicacionRepository.findAll();
    }

    public Publicacion obtenerPublicacion(Integer id){
        return publicacionRepository.findById(id).get();
    }

    public void agregarPublicacion(Publicacion publicacion){
         publicacionRepository.save(publicacion);
    }

    public void eliminarPublicacion(Integer id){
        publicacionRepository.deleteById(id);
    }

}
