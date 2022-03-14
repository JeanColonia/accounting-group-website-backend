package com.grupocontable.website.service;

import com.grupocontable.website.model.ItemsTemario;
import com.grupocontable.website.repository.ItemsTemarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemsTemarioService {
    private final ItemsTemarioRepository itemsTemarioRepository;

    public ItemsTemarioService(ItemsTemarioRepository itemsTemarioRepository) {
        this.itemsTemarioRepository = itemsTemarioRepository;
    }

    public List<ItemsTemario> listar(){
        return itemsTemarioRepository.findAll();
    }

    public ItemsTemario obtenerItemsTemario(Integer id){
      return itemsTemarioRepository.findById(id).get();
    }

    public void agregarItemsTemario(ItemsTemario itemsTemario){
        itemsTemarioRepository.save(itemsTemario);
    }

    public void eliminarItemsTemario(Integer id){
        itemsTemarioRepository.deleteById(id);
    }
}
