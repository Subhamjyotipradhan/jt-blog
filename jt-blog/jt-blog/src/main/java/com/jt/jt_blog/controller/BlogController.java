package com.jt.jt_blog.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.jt_blog.model.Blog;
import com.jt.jt_blog.service.BlogService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class BlogController {
     private final BlogService blogService;
    
    @GetMapping
    public String home(Model model) {
        model.addAttribute("blogs", blogService.getBlogs());
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "add-blog";
    }

    @PostMapping("/add-blog")
    public  String addBlog(@ModelAttribute Blog blog) {
        
        blogService.addBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable int id , Model model) {
        
        var blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog-detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable int id, Model model) {
        var blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "edit-blog";
    }

    @PostMapping("/update-blog")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/";
    }
}
