package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.Blog;
import com.grupocontable.website.repository.BlogRepository;
import com.grupocontable.website.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BlogServiceImp implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImp(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @Override
    public Blog agregarBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog actualizarBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Set<Blog> obtenerBlogs() {
        return new LinkedHashSet<>(blogRepository.findAll());
    }

    @Override
    public Blog obtenerBlog(Integer idBlog) {
        return blogRepository.findById(idBlog).get();
    }

    @Override
    public void eliminarBlog(Integer idBlog) {
    Blog blog = new Blog();
    blog.setIdBlog(idBlog);
    blogRepository.delete(blog);
    }
}
