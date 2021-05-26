package by.project.spring.calculate.controller;

import by.project.spring.calculate.dao.HistoryDAO;
import by.project.spring.calculate.model.entity.Operation.HistoryOperation;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryDAO historyDAO;
    @GetMapping
    public String showHistory(Model model,
                              HttpSession session){
        model.addAttribute("history",historyDAO.getByUser((User)session.getAttribute("user")));
        return "history";
    }
}
