public class Printer {

    private String queue = "";
    int pagesToPrint;
    int totalPages;

    public void append(String text) {
        append(text, "Имя файла неизвестно", 1);
    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text, String name, int pages) {
        queue = queue + "\n" + text + " - " + name + " - " + pages + " стр.";
        pagesToPrint += pages;
        totalPages += pages;
    }

    public void clear() {
        queue = "";
        pagesToPrint = 0;
    }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
            clear();
        }
    }

    public int getPendingPagesCount() {
        return pagesToPrint;
    }

    public int pagesAmount() {
        return totalPages;
    }
}