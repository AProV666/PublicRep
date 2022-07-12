import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ReadAllLinks {

    public static Set<String> uniqueURL = new HashSet<String>();
    public static String my_site;
    public static List<String> treeUrls = new ArrayList<>();
    public static String path = "src/main/resources/TreeUrls.txt";

    public static void main(String[] args) {

        ReadAllLinks obj = new ReadAllLinks();
        my_site = "stackoverflow.com";
        obj.get_links("http://stackoverflow.com/");

//        for (String url : treeUrls) {
//            System.out.println(st);
//        }

        try {
            PrintWriter writer = new PrintWriter(path);
            for (String url : treeUrls) {
                writer.write(url + "\n");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void get_links(String url) {
        try {
            Connection con = Jsoup.connect(url).userAgent("Safari/535.21").timeout(10000);
            Connection.Response resp = con.execute();
            Document doc = null;
            if (resp.statusCode() == 200) {
                doc = con.get();
            }

//            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
            Elements links = doc.select("a");

            if (links.isEmpty()) {
                return;
            }

            links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
                boolean add = uniqueURL.add(this_url);
                if (add && this_url.contains(my_site)) {
                    System.out.println(this_url);
                    treeUrls.add(this_url);
                    get_links(this_url);
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
