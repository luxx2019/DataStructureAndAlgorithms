package queue;

/**
 * 带头节点的写法
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;   //头节点
    private Node<E> rear;   //尾节点
    private int size;

    public LinkedQueue() {
        head = new Node<E>();
        rear = head;
    }

    private boolean isEmpty() {
        return rear == head;
    }

    @Override
    public void push(E e) {
        Node<E> node = new Node<>();
        node.data = e;
        rear.next = node;
        node.pre = rear;
        rear = rear.next;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E e = head.next.data;
        head = head.next;
        size++;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.data;
    }

    @Override
    public int size() {
        return size;
    }
}
