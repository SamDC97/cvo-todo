package be.cvo.todo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer personId;
    private Integer taskId;
}
