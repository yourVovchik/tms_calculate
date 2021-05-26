package by.project.spring.calculate.controller;

import by.project.spring.calculate.dao.UserDAO;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    final
    UserDAO userDAO;

    public AuthorizationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String reg(Model model){
        model.addAttribute("user",new User());
        return "auth";
    }

    @PostMapping
    public String registration(@ModelAttribute("user")@Valid User user,
                               BindingResult result,
                               HttpSession session,
                               Model model){
        if(result.hasErrors() && !result.hasFieldErrors("username")){
            for(FieldError fieldError : result.getFieldErrors()){
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "auth";

        }
        if(userDAO.contains(user.getLogin())){
            if(userDAO.getByLogin(user.getLogin()).getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);
                return "redirect:/calc";
            }
        }
        model.addAttribute("message","Неверные данные");
        return "auth";
    }
}
