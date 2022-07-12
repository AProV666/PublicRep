public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.print();

        printer.append("Денег нет, но вы держитесь");
        printer.append("Обнуление деда", "Жизнь 2022");
        printer.append("Человек, о котором нельзя говорить", "Россия будущего", 2022);

        System.out.println(printer.getPendingPagesCount());

        printer.print();

        System.out.println(printer.getPendingPagesCount());

        System.out.println("Общее количество страниц: " + printer.pagesAmount());
    }
}
