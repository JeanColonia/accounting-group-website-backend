package com.grupocontable.website.service.cloudinary;

import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.ImagenCurso;
import com.grupocontable.website.repository.CursoRepository;
import com.grupocontable.website.repository.ImagenRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenCursoService {

    private final ImagenRepository imagenRepository;
    private final CursoRepository cursoRepository;
    public ImagenCursoService(ImagenRepository imagenRepository, CursoRepository cursoRepository){
        this.imagenRepository = imagenRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<ImagenCurso> listarImagenes(){
        return imagenRepository.findByOrderById();
    }

    public Optional<ImagenCurso> obtenerImagen(Integer id){
       return imagenRepository.findById(id);
    }
    public boolean exists(Integer id){
        return imagenRepository.existsById(id);
    }

    public void save(ImagenCurso imagenCurso){
        imagenRepository.save(imagenCurso);



    }



    public void delete(int id){
        imagenRepository.deleteById(id);
    }
}
