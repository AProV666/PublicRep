
import java.util.ArrayList;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.add("Наказать");
        todoList.add("Приготовить ужин");

        todoList.add(2, "Погулять");
        todoList.add(3, "Погулять 2");

        todoList.edit(3, "НЕ погулять");
        todoList.add(-10, "Сходить");
        todoList.delete(2);

        ArrayList<String> todoList1 = todoList.getTodos();
        for (int i = 0; i < todoList1.size(); i++) {
            int j = todoList1.size() - i - 1;
            System.out.println(todoList1.get(j));
        }
    }
}
