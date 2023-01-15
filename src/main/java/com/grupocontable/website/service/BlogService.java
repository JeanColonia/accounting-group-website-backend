package com.grupocontable.website.service;

import com.grupocontable.website.model.Blog;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface BlogService {
    Blog agregarBlog(Blog blog);
    Blog actualizarBlog(Blog blog);
    Set<Blog> obtenerBlogs();
    Blog obtenerBlog(Integer idBlog);
    void eliminarBlog(Integer idBlog);
};
