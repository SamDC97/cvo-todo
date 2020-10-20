package be.cvo.todo.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoDTO {
    private Integer id;
    private Integer personId;
    private Integer taskId;

    private String personName;
    private String taskDescription;
}
