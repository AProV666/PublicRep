public class Main {

    public static void main(String[] args) {

        Book book = new Book("The book of Eli", "Albert Hughes", 666, 12567);

        System.out.println(book.getName());
        System.out.println(book.getAuthor());
        System.out.println(book.getPages());
        System.out.println(book.getIsbn());


        Product product = new Product("book", 8659832);

        System.out.println(product.getName());
        System.out.println(product.getBarCode());
        product.setPrice(598);
        System.out.println(product.getPrice());

    }
}
