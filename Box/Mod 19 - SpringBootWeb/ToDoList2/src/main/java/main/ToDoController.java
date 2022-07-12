package main;

import main.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ToDoController {

    //получение списка всех дел
    @GetMapping("/todos/")
    public List<ToDo> list() {
        return Storage.getAllToDos();
    }

    //создание нового дела
    @PostMapping("/todos/")
    public int add(@RequestBody ToDo todo) {
        return Storage.addToDo(todo);
    }

    //возвращает дело с id
    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id) {
        ToDo todo = Storage.getToDo(id);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    //удаление дела
    @DeleteMapping("/todos/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (Storage.getToDo(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.deleteToDO(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    //обновление дела
    @PutMapping("/todos/{id}")
    public ResponseEntity update(@PathVariable int id, ToDo todo) {
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.updateToDo(id, todo);
        return new ResponseEntity(HttpStatus.OK);
    }

    //удаление всего списка
    @DeleteMapping("/todos/")
    public void deleteToDoList() {
        Storage.deleteToDoList();
    }

}