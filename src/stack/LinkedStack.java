package stack;

import queue.Node;

/**
 * 带头节点的写法
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> button;   //栈底
    private Node<E> top;   //栈顶
    private int size;

    public LinkedStack() {
        button = new Node<E>();
        top = button;
    }

    private boolean isEmpty() {
        return top == button;
    }

    @Override
    public boolean push(E e) {
        Node<E> node = new Node<>();
        node.data = e;

        top.next = node;
        node.pre = top;

        top = top.next;

        size++;

        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;

        E e = top.data;
        top = top.pre;

        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }
}
