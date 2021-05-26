package by.project.spring.calculate.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class ExController {
    @ExceptionHandler(NullPointerException.class)
    public String npe(NullPointerException e, Model model){
        model.addAttribute("message",e.getMessage());
        return "error";
    }
    @ExceptionHandler(RuntimeException.class)
    public String npe(RuntimeException e, Model model){
        model.addAttribute("message",e.getMessage());
        return "error";
    }
    @ExceptionHandler(Exception.class)
    public String npe(Exception e, Model model){
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}
