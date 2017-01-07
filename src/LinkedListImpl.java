
public class LinkedListImpl implements List {

    private Node head;
    private int mySize;

    public LinkedListImpl() {
        this.mySize = 0;
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        Object node = head;
        if (node == null) {
            return true;
        }
        return false;
    }

    @Override
    /** returns the size of the list */
    public int size() {
        return mySize;
    }

    @Override
    public ReturnObject get(int index) {
        if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            int nodeCount = 0;
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                if (nodeCount == index) {
                    return new ReturnObjectImpl(currentNode.getData());
                }
                currentNode = currentNode.getNextNode();
                nodeCount++;
            }
            return new ReturnObjectImpl(currentNode.getData());
        }
    }

    @Override
    public ReturnObject remove(int index) {
        if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (index == 0) {
                Node nodeToRemove = head;
                head = nodeToRemove.getNextNode();
                nodeToRemove.setNextNode(null);
                mySize--;
                Object toReturn = nodeToRemove.getData();
                ReturnObjectImpl returnObject = new ReturnObjectImpl(toReturn);
                return returnObject;
            } else {
                int nodeCount = 0;
                Node auxiliary = head;
                while (nodeCount != index - 1) {
                    auxiliary = auxiliary.getNextNode();
                    nodeCount++;
                }
                Node nodeToRemove = auxiliary.getNextNode();
                auxiliary.setNextNode(nodeToRemove.getNextNode());
                nodeToRemove.setNextNode(null);
                mySize--;
                Object toReturn = nodeToRemove.getData();
                ReturnObjectImpl returnObject = new ReturnObjectImpl(toReturn);
                return returnObject;
            }
        }
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            int nodeCount = 0;
            if (index == 0) {
                Node nodeToBeAdded = new Node(item);
                nodeToBeAdded.setNextNode(head);
                head = nodeToBeAdded;
                nodeCount++;
                mySize++;
            } else {

                Node auxiliary = head;
                while (nodeCount != index - 1) {
                    auxiliary = auxiliary.getNextNode();
                    nodeCount++;
                }
                Node nodeToBeAdded = new Node(item);
                nodeToBeAdded.setNextNode(auxiliary.getNextNode());
                auxiliary.setNextNode(nodeToBeAdded);
                mySize++;
            }
        }
        Object emptyObject = null;
        return new ReturnObjectImpl(emptyObject);
    }

    @Override
    public ReturnObject add(Object item) {

        if (item == null) {
            ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return returnObj;
        }
        if (head == null) {
            head = new Node(item);
            mySize++;
        } else {
            Node nodeToBeAdded = new Node(item);
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(nodeToBeAdded);
            mySize++;
        }
        Object emptyObject = null;
        return new ReturnObjectImpl(emptyObject);
    }

    public String toString() {
        String s = "[";
        Node currentNode = head;
        if (head == null) {
            s += "]";
            return s;
        }

        while (currentNode.getNextNode() != null) {
            s = s + currentNode.getData() + ",";
            currentNode = currentNode.getNextNode();
        }
        s = s + currentNode.getData() + "]";
        return s;
    }

}
