package com.grupocontable.website.service;

import com.grupocontable.website.model.Temario;
import com.grupocontable.website.repository.TemarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemarioService {
    private final TemarioRepository temarioRepository;

    public TemarioService(TemarioRepository temarioRepository) {
        this.temarioRepository = temarioRepository;
    }

    public List<Temario> listar (){
        return temarioRepository.findAll();
    }

    public Temario obtenerTemario(Integer id){
        return temarioRepository.findById(id).get();
    }

    public void agregarTemario(Temario temario){
        temarioRepository.save(temario);
    }

    public void eliminarTemario(Integer id){
        temarioRepository.deleteById(id);
    }
}
