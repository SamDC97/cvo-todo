package be.cvo.todo.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private Integer personId;
    private Integer taskId;
}
