package queue;

/**
 * 关于队列头尾指针的一些想法：
 * 1、头指针指向队列的头下标，尾指针指向队列尾下标
 *   头尾指针指向同一个下标时，队列长度为1，front == rear + 1时，队列为空
 *   进队列时，rear++； arr[rear] = data
 *   出队列时，front++
 *   应该初始化 front = 0； rear = -1
 *   若头尾指针同时指向数组最后一个下标，此时队列长度为1，需要出队列的话，front++，front的值就会变成arr.length
 *   解决办法:当front == arr.length时，队列判断为空，无法出队列，不会访问arr[arr.length],不需要处理
 * 2、使用网课中的方法，头指针指向队列头的前一个下标，尾指针指向队列尾下标
 *   头尾指针指向同一个下标时，队列长度为0，front == rear时，队列为空
 *   进队列时，rear++； arr[rear] = data
 *   出队列时，front++
 *   应该初始化 front = -1； rear = -1；
 *   此时较为直观，两种方法都可以
 * 3、头尾指针的设置不止上述两种方法，不再讨论，下面的代码采用了第二种写法
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
        //当队列存储数据的下标为3、4、5时。front=2,rear=5;
        //front指向第一个数据下标减1，rear指向最后一个数据的下标
    }
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    public boolean isEmpty() {
        return rear == front;
    }
    public void addQueue(int n) {
        if(isFull()){
            System.out.println("队列已满，无法添加新数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据");
        }
        front++;
        return arr[front];
    }
    public void showQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front + 1; i <= rear; i++){
            System.out.print(arr[i] + "\t");
        }
    }
}
