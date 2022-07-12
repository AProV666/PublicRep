package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    //получение списка всех дел
    @GetMapping("/todos/")
    public List<ToDo> list() {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDos = new ArrayList<>();
        for(ToDo todo : toDoIterable) {
            toDos.add(todo);
        }
        return toDos;
    }

    //создание нового дела
    @PostMapping("/todos/")
    public int add(@RequestBody ToDo todo) {
        ToDo newToDo = toDoRepository.save(todo);
        return newToDo.getId();
    }

    //возвращает дело с id
    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (!optionalToDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalToDo.get(), HttpStatus.OK);
    }

    //удаление дела
    @DeleteMapping("/todos/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (!optionalToDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        toDoRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    //обновление дела
    @PutMapping("/todos/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody ToDo todo) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (!optionalToDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todo.setId(id);
        toDoRepository.save(todo);
        return new ResponseEntity(HttpStatus.OK);
    }

    //удаление всего списка
    @DeleteMapping("/todos/")
    public void deleteToDoList() {
        toDoRepository.deleteAll();
    }
}