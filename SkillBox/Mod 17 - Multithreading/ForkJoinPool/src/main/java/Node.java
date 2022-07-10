import java.util.ArrayList;
import java.util.List;

public class Node {
    private String url;
    private List<Node> children;
    private int level;

    public Node(String url) {
        this.url = url;
        children = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(url + "\n");
        for (Node child : children) {
            builder.append("  ".repeat(level + 1) + child.toString());
        }
        return builder.toString();
    }

    private void setLevel(int level) {
        this.level = level;
    }
}