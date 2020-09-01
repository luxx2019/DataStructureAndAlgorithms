package queue;

/**
 * 关于循环队列的一些想法
 * 循环队列与普通队列大致相同，不同点在于，出队列和进队列时， front 和 rear 自增后需要模上数组的长度
 * 此时存在一个问题需要解决，队空和队满两种情况无法做出区分，此处以头指针指向队列的头下标，尾指针指向队列尾下标进行说明
 * 判空判满的的条件都是 front == (rear + 1) % arr.length
 * 此时我们把队列尾部留下一个空格不用，用以区分
 * 那么，此时判空条件不变，判满的条件为 front == (rear + 2) % arr.length
 * 为了与 ArrayQueue 不同，此处代码采用不一样的方式，头指针指向队列的头下标，尾指针指向队列尾下标
 *
 * 在debug的过程中，发现当 front 初始值为 0，rear 初始值为 -1 时，如果不进行一次出队列操作，那么就永远不会满足判满的条件
 * 因为是循环队列，不在乎从数组的什么地方开始存储队列数据，更改初始值为 front = 1 , rear = 0
 */
public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public static void main(String[] args) {
        CircleArrayQueue aq = new CircleArrayQueue(10);
        aq.addQueue(3);
        aq.addQueue(5);
        aq.addQueue(7);
        aq.addQueue(3);
        aq.addQueue(5);
        aq.addQueue(7);
        aq.addQueue(3);
        aq.addQueue(5);
        aq.addQueue(7);
        aq.addQueue(3);
        aq.addQueue(5);
        aq.addQueue(7);
        System.out.println(aq.getQueue());
        aq.showQueue();
        System.out.println();
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());
        System.out.println(aq.getQueue());

    }

    CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 1;
        rear = 0;
        //当队列存储数据的下标为3、4、5时。front=2,rear=5;
        //front指向第一个数据下标减1，rear指向最后一个数据的下标
    }

    public boolean isFull() {
        return front == (rear + 2) % arr.length;
    }
    public boolean isEmpty() { return front == (rear + 1) % arr.length; }
    public void addQueue(int n) {
        if(isFull()){
            System.out.println("队列已满，无法添加新数据");
            return;
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        int re = arr[front];
        front = (front + 1) % maxSize;
        return re;
    }

    public void showQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
        }
        if (rear >= front)
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + "\t");
        else {
            for (int i = front; i <= maxSize - 1; i++)
                System.out.print(arr[i] + "\t");
            for (int i = 0; i <= rear; i++)
                System.out.print(arr[i] + "\t");
        }
    }
}
