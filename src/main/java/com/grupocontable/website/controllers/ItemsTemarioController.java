package com.grupocontable.website.controllers;

import com.grupocontable.website.model.ItemsTemario;
import com.grupocontable.website.service.ItemsTemarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemsTemario/api")
public class ItemsTemarioController {
    private final ItemsTemarioService itemsTemarioService;

    public ItemsTemarioController(ItemsTemarioService itemsTemarioService) {
        this.itemsTemarioService = itemsTemarioService;
    }

    @GetMapping("/listar")
    public List<ItemsTemario> listar(){
        return itemsTemarioService.listar();
    }

    @GetMapping("/obtenerItemTemario/{id}")
    public ResponseEntity<ItemsTemario> obtenerItem(@PathVariable Integer id){
        try{
            ItemsTemario item=itemsTemarioService.obtenerItemsTemario(id);
            return new ResponseEntity<ItemsTemario>(item,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregarItemTemario")
    public void agregarItemTemario(ItemsTemario itemsTemario){
         itemsTemarioService.agregarItemsTemario(itemsTemario);
    }
    @PutMapping("/actualizarItemTemario/{id}")
    public ResponseEntity<?> actualizarItemTemario(@RequestBody ItemsTemario itemsTemario, @PathVariable Integer id){
            try{
                ItemsTemario item=itemsTemarioService.obtenerItemsTemario(id);

                item.setTituloItem(itemsTemario.getTituloItem());
                item.setDescripcionItem(itemsTemario.getDescripcionItem());

                return new ResponseEntity<ItemsTemario>(item, HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<ItemsTemario>(HttpStatus.NOT_MODIFIED);
            }
    }

    @DeleteMapping("/eliminarTemario/{id}")
    public void eliminarItemTemario(@PathVariable Integer id){
        itemsTemarioService.eliminarItemsTemario(id);
    }
}
