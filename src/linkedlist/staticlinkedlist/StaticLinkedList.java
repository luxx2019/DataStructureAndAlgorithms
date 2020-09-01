package linkedlist.staticlinkedlist;

public class StaticLinkedList {
    public static final int MAX_SIZE = 1000;
    private Node[] nodes = new Node[MAX_SIZE];

    public StaticLinkedList() {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            nodes[i].next = i + 1;
        }
        nodes[MAX_SIZE - 1].next = 0;
    }

    public void add(String data) {

    }
}

class Node {
    public String data;
    public int next;
}