package src;

/**
 * Represents a node in a singly linked list. This node
 * has data and points to the next node in the list
 * 
 *
 *
 * @param <T>
 *            generic type for Node
 */
public class Node<T> {
    private T data;
    private Node<T> next;


    /**
     * Creates a new node with given data
     * 
     * @param data
     *            the data to put in node
     */
    public Node(T data) {
        this.data = data;
    }


    /**
     * Sets the next node
     * 
     * @param node
     *            the next node
     */
    public void setNext(Node<T> node) {
        this.next = node;
    }


    /**
     * Gets the next node
     * 
     * @return the next node
     */
    public Node<T> next() {
        return this.next;
    }


    /**
     * Gets the data from a node
     * 
     * @return data in the node
     */
    public T getData() {
        return this.data;
    }


    /**
     * Sets the data for a node
     * 
     * @param anEntry
     *            the data you are putting in
     */
    public void setData(T anEntry) {
        data = anEntry;
    }

}
