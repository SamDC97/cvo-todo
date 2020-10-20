package be.cvo.todo;

import be.cvo.todo.service.ToDoDTO;
import be.cvo.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    public List<ToDoDTO> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @PostMapping(path = "/add-todo", consumes = "application/json")
    public void addToDo(@RequestBody ToDoRequest toDoRequest){
        toDoService.addToDo(toDoRequest.getTaskId());
    }
}
