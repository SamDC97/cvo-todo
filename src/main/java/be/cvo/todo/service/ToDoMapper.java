package be.cvo.todo.service;

import be.cvo.todo.domain.ToDo;
import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {

    public ToDoDTO map(ToDo toDo) {
        return ToDoDTO.builder()
                .id(toDo.getId())
                .personId(toDo.getPersonId())
                .taskId(toDo.getTaskId())
                .build();
    }
}
