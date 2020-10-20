package be.cvo.todo.service;

import be.cvo.todo.domain.ToDo;
import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {
    private String personName;
    private String taskDescription;

    public ToDoDTO map(ToDo toDo){
        return new ToDoDTO(toDo.getId(), toDo.getPersonId(), toDo.getTaskId(), personName, taskDescription);
    }
}
