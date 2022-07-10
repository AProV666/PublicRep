package main;

import main.model.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, ToDo> todos = new HashMap<>();

    public static List<ToDo> getAllToDos() {
        ArrayList<ToDo> todosList = new ArrayList<>();
        todosList.addAll(todos.values());
        return todosList;
    }

    public static int addToDo(ToDo todo) {
        int id = currentId++;
        todo.setId(id);
        todos.put(id, todo);
        return id;
    }

    public static ToDo getToDo(int todoId) {
        if (todos.containsKey(todoId)) {
            return todos.get(todoId);
        }
        return null;
    }

    public static void deleteToDO(int todoId) {
        if (todos.containsKey(todoId)) {
            todos.remove(todoId);
        }
    }

    public static void updateToDo(int todoId, ToDo todo) {
        if (todos.containsKey(todoId)) {
            todos.put(todoId, todo);
        }
    }

    public static void deleteToDoList() {
        todos = new HashMap<>();
        currentId = 1;
    }
}
