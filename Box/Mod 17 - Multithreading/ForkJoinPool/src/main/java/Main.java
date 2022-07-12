import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static Set<String> uniqueUrl = new HashSet<>();

    private static String url = "https://lenta.ru/";
    private static String regex = "https://lenta.ru/";
    private static String path = "src/main/resources/TreeUrls.txt";


    public static void main(String[] args) {

        Node root = new Node(url);
        GetUrlsFromSite getUrlsFromSite = new GetUrlsFromSite(root, uniqueUrl, regex);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(getUrlsFromSite);
        System.out.println(root);
        printToFile(root);
    }

    private static void printToFile(Node node) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(node.toString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}