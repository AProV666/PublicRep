package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> todos = new ArrayList<>();
        for(ToDo todo : toDoIterable) {
            todos.add(todo);
        }
        model.addAttribute("todos", todos);
        model.addAttribute("toDoCount", todos.size());
        return "index";
    }
}
