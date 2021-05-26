package by.project.spring.calculate.controller;

import by.project.spring.calculate.dao.HistoryDAO;
import by.project.spring.calculate.model.entity.Operation.HistoryOperation;
import by.project.spring.calculate.model.entity.Operation.Operation;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/calc")
public class CalculateController {
    @Autowired
    @Qualifier("getOperation")
    Map<String,Operation> operationMap;
    @Autowired
    HistoryDAO historyDAO;

    @GetMapping
    public String viewPage(){
        return "calc";
    }

    @PostMapping
    public String calculate(
            Model model,
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b,
            @RequestParam(name = "operation") String operation,
            @Autowired HistoryOperation historyOperation,
            HttpSession httpSession
    ){
        model.addAttribute("result",operationMap.get(operation).result(a,b));
        historyOperation.setA(a);
        historyOperation.setB(b);
        historyOperation.setOperation(operation);
        historyOperation.setResult(operationMap.get(operation).result(a,b));
        historyOperation.setUser((User)httpSession.getAttribute("user"));
        historyDAO.setOperation(historyOperation);
    return "calc";
    }
}
