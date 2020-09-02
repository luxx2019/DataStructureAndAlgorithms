package queue;

public interface Queue<E> {
    /**
     * 添加元素
     */
    void push(E e);

    /**
     * 出列，返回队列头部并删除，队列为空则返回null
     */
    E pop();

    /**
     * 查看队列头部元素，但不删除，队列为空则返回null
     */
    E peek();


    /**
     * 返回队列中元素个数
     */
    int size();
}
