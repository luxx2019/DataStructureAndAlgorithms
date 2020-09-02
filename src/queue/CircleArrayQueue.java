package queue;

/**
 * 关于循环队列的一些想法
 * 循环队列与普通队列大致相同，不同点在于，出队列和进队列时， front 和 rear 自增后需要模上数组的长度
 * 此时存在一个问题需要解决，队空和队满两种情况无法做出区分，此处以头指针指向队列的头下标，尾指针指向队列尾下标进行说明
 * 判空判满的的条件都是 front == (rear + 1) % arr.length
 * 此时我们把队列尾部留下一个空格不用，用以区分
 * 那么，此时判空条件不变，判满的条件为 front == (rear + 2) % arr.length
 *
 * 在debug的过程中，发现当 front 初始值为 0，rear 初始值为 -1 时，如果不进行一次出队列操作，那么就永远不会满足判满的条件
 * 因为是循环队列，不在乎从数组的什么地方开始存储队列数据，更改初始值为 front = 0 , rear = size - 1
 *
 * 类型参数无法实例化
 */
public class CircleArrayQueue<E> implements Queue<E> {
    private int size = 1000;
    private int front;
    private int rear;
    private Object[] elements;

    public CircleArrayQueue() {
        elements = new Object[size];
        front = 0;
        rear = size - 1;
    }

    public CircleArrayQueue(int size) {
        this.size = size;
        elements = new Object[size];
        front = 0;
        rear = size - 1;
    }

    public boolean isFull() {
        return front == (rear + 2) % size;
    }

    public boolean isEmpty() {
        return front == (rear + 1) % size;
    }

    public boolean push(E e) {
        if(isFull()) return false;

        rear = (rear + 1) % size;
        elements[rear] = e;

        return true;
    }

    public E pop(){
        if(isEmpty()) return null;

        E e = (E) elements[front];

        front = (front + 1) % size;
        return e;
    }

    public E peek() {
        if(isEmpty()) return null;

        E e = (E) elements[front];

        return e;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        return rear >= front ? rear + 1 - front : rear + size + 1 - front;
    }
}
