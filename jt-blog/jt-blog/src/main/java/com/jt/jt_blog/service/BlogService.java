package com.jt.jt_blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jt.jt_blog.model.Blog;
import com.jt.jt_blog.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private static final String BLOG_TABLE = "blogs";
    private final JdbcTemplate jdbcTemplate ;
    private final BlogRepository blogRepository;

    public List<Blog> getBlogs() {
        // var sql = "SELECT * fROM " + BLOG_TABLE;
        // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class)) ;

        return blogRepository.findAll();
           
    }
    public void addBlog(Blog blog) {
        // var sql = "INSERT INTO " + BLOG_TABLE + "(heading, description) VALUES (?, ?)";
        // jdbcTemplate.update(sql, blog.getHeading(), blog.getDescription());

        blogRepository.save(blog); //save - insert row into table
    }

    public Blog getBlogById(int id) {
        // var sql = "SELECT * FROM " + BLOG_TABLE + " WHERE id = ?";
        // return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class), id);

        Optional<Blog> optionalBlog = blogRepository.findById(id);
        // if(optionalBlog.isPresent()){
        //     Blog exisinBlog = optionalBlog.get();
        //     return existingBlog;
        // }else{
        //     throw new Run
        // }
        // if (!optioanBlog.) {
            
        // }

        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not exist with id"+id));

        // findById() -> it extract a row by matching the primary key
    }

    public void delete(int id) {
        // var sql = "DELETE FROM %s WHERE id = ?";
        // jdbcTemplate.update(sql.formatted(BLOG_TABLE), id);

        // Blog existingBlog = getBlogById(id);
        // blogRepository.delete(existingBlog);

        blogRepository.delete(getBlogById(id));
    }

    public void updateBlog(Blog newBlog) {
        // var id = blog.getId();
        // var heading = blog.getHeading();
        // var description = blog.getDescription();

        // var sql = "UPDATE %s SET heading = ?, description = ? WHERE id = ?".formatted(BLOG_TABLE);
        // jdbcTemplate.update(sql, heading, description, id);

        // Blog existingBlog = getBlogById(newBlog.getId());
        // existingBlog.setHeading(newBlog.getHeading());
        // existingBlog.setDescription(newBlog.getDescription());
        blogRepository.save(newBlog);

    }
}