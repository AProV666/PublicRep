import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveAction;

public class GetUrlsFromSite extends RecursiveAction {

    private Node node;
    private Set<String> uniqueUrl;
    private String regex;

    public GetUrlsFromSite(Node node, Set<String> uniqueUrl, String regex) {
        this.node = node;
        this.uniqueUrl = uniqueUrl;
        this.regex = regex;
    }

    @Override
    protected void compute() {

        String url = node.getUrl();

        try {
            Document doc = Jsoup.connect(url).get();

            Elements links = doc.select("a[href]");

            List<GetUrlsFromSite> subTasks = new LinkedList<>();

            for (Element link : links) {

                if (uniqueUrl.add(link.attr("abs:href"))) {

                    if (link.attr("abs:href").contains(regex)
                            && !link.attr("abs:href").contains("#")
                            && uniqueUrl.contains(link.attr("abs:href"))) {

                        Node child = new Node(link.attr("abs:href"));
                        GetUrlsFromSite task = new GetUrlsFromSite(child, uniqueUrl, regex);
                        task.fork();
                        subTasks.add(task);
                        node.addChild(child);
                    }
                }
            }

            Thread.sleep(150);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
