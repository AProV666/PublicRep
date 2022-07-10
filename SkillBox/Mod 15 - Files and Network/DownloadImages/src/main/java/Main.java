import java.io.*;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String webSiteURL = "https://lenta.ru/";
    private static final String folderPath = "/Users/a_pro/Desktop/down";

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect(webSiteURL).get();
            Elements img = doc.getElementsByTag("img");
            String regex = "https?:\\/\\/icdn[^, \\s]+";

            for (Element el : img) {
                String src = el.absUrl("src");
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(src);

                if (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    src = src.substring(start, end);
                } else {
                    continue;
                }

                System.out.println("Image Found!");
                System.out.println("src attribute is : " + src);
                getImages(src);
            }
        } catch (IOException ex) {
            System.err.println("There was an error");
            ex.printStackTrace();
        }
    }

    private static void getImages(String src) throws IOException {
        String folder = null;
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }
        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());
        System.out.println(name);

        URL url = new URL(src);
        InputStream in = url.openStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + name));

        for (int b; (b = in.read()) != -1; ) {
            out.write(b);
        }
        out.close();
        in.close();
    }
}