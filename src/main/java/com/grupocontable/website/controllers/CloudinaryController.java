package com.grupocontable.website.controllers;


import com.grupocontable.website.dto.Mensaje;
import com.grupocontable.website.model.Curso;
import com.grupocontable.website.model.ImagenCurso;
import com.grupocontable.website.service.CursoService;
import com.grupocontable.website.service.Impl.CursoServiceImp;
import com.grupocontable.website.service.cloudinary.CloudinaryService;
import com.grupocontable.website.service.cloudinary.ImagenCursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin("*")
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;
    private final CursoService cursoService;
    private final ImagenCursoService imagenCursoService;
    public CloudinaryController(CloudinaryService cloudinaryService, CursoService cursoService,ImagenCursoService imagenCursoService){
        this.cloudinaryService = cloudinaryService;
        this.cursoService = cursoService;
        this.imagenCursoService = imagenCursoService;

    }

    @GetMapping("/list")
    public ResponseEntity<List<ImagenCurso>> listarTodasLasImagenes(){
        return  ResponseEntity.ok(imagenCursoService.listarImagenes());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity( new Mensaje("Imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result  = cloudinaryService.upload(multipartFile);
        ImagenCurso imagenCurso = new ImagenCurso((String) result.get("original_filename"),
                (String) result.get("url"), (String) result.get("public_id"));
        imagenCursoService.save(imagenCurso);
        return new ResponseEntity( imagenCurso, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws IOException {
        if(!imagenCursoService.exists(id)){
            return new ResponseEntity( new Mensaje("No existe imagen"), HttpStatus.NOT_FOUND);
        }
        ImagenCurso imagenCurso = imagenCursoService.obtenerImagen(id).get();
        Map result = cloudinaryService.delete(imagenCurso.getImagenId());
        imagenCursoService.delete(id);
        return new ResponseEntity(new Mensaje("Imagen eliminada"), HttpStatus.OK);
    }
}
