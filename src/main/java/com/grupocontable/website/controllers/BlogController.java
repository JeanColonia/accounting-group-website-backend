package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Blog;
import com.grupocontable.website.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog/api")
@CrossOrigin("*")
public class BlogController {

    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }


    @PostMapping("/")
    public ResponseEntity<Blog> guardarBlog(@RequestBody Blog blog){
    Blog blogSaved = blogService.agregarBlog(blog);
        return ResponseEntity.ok(blogSaved);
    }

    @GetMapping("/{idBlog}")
    public Blog obtenerBlog(@PathVariable("idBlog") Integer idBlog){
        return blogService.obtenerBlog(idBlog);
    }

    @GetMapping("/")
    public ResponseEntity<?> ObtenerBlogs(){
        return ResponseEntity.ok(blogService.obtenerBlogs());
    }

    @PutMapping("/")
    public Blog actualizarBlog(@RequestBody Blog blog){
        return blogService.actualizarBlog(blog);
    }


    @DeleteMapping("/{idBlog}")
    public void eliminarBlog(@PathVariable("idBlog") Integer idBlog){
        blogService.eliminarBlog(idBlog);
    }
}
