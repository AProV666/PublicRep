
import java.util.ArrayList;

public class TodoList {

    ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= list.size()) {
            list.add(index, todo);
        } else {
            list.add(list.size(), todo);
        }

    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (todo.equals("")) {
            System.out.println("Невозможно изменить дело");
        } else {
            list.set(index, todo);
        }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Введен неверный индекс");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }
}