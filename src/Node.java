
public class Node {
    private Node nextNode;
    private Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getData() {
        return data;
    }

}
