package com.example.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web;

import ch.qos.logback.core.model.Model;


@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void helloSpring(PrintWriter printWriter){
        System.out.println("Hello Web");
        printWriter.println("Hello web in Browser");
    }

    // @RequestMapping({"/","/home"})
    // public void home(PrintWriter printWriter){
    //     printWriter.println("Home Page");
    // }

    // @RequestMapping("/contact")
    // public void contactPage(PrintWriter printWriter){
    //     printWriter.println("contact page");
    //     printWriter.println("devtool work");
    // }

    @RequestMapping({"/","/home"})
    public String homePage(){
        return"home";
    }
    @RequestMapping("/contact")
    public String contactPage(Model model){
        model.addAttribute("name","JT");
        return"contact";
    }

    @RequestMapping("/add")
    public String addPage(){
        return"add";
    }

    @RequestMapping("/read")
    public String readPage(){
        return"read";
    }

    @RequestMapping("/update")
    public String updatePage(){
        return"update";
    }

    @RequestMapping("/delete")
    public String deletePage(){
        return"delete";
    }

}
