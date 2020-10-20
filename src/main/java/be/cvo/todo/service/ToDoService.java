package be.cvo.todo.service;

import be.cvo.todo.domain.ToDo;
import be.cvo.todo.domain.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    public static final String PERSON = "/person/";
    public static final String TASK = "/task/";
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private ToDoMapper toDoMapper;

    @Value("${service.person.url}")
    private String personURL;
    @Value("${service.task.url}")
    private String taskURL;

    public List<ToDoDTO> getAllToDos() {
        List<ToDoDTO> toDos = toDoRepository.findAll().stream()
                .map(toDoMapper::map)
                .collect(Collectors.toList());

        for (ToDoDTO toDoDTO : toDos) {
            addPersonName(toDoDTO);
            RestTemplate rtTask = new RestTemplate();
            TaskDTO taskDTO = rtTask.getForObject(taskURL + TASK + toDoDTO.getTaskId(), TaskDTO.class);
            toDoDTO.setTaskDescription(taskDTO.getDescription());
        }

        return toDos;
    }

    private void addPersonName(ToDoDTO toDoDTO) {
        if (toDoDTO.getPersonId() != null) {
            RestTemplate rtPerson = new RestTemplate();
            PersonDTO personDTO = rtPerson.getForObject(personURL + PERSON + toDoDTO.getPersonId(), PersonDTO.class);
            toDoDTO.setPersonName(personDTO.getName());
        }
    }

    public void addToDo(Integer taskId) {
        toDoRepository.save(ToDo.builder().taskId(taskId).personId(1).build());
    }
}
