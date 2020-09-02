package stack;

public interface Stack<E> {
    /**
     * 添加元素
     * 成功则返回true，失败返回false
     */
    boolean push(E e);

    /**
     * 出列，返回栈顶元素并删除，栈为空则返回null
     */
    E pop();

    /**
     * 查看栈顶元素，但不删除，栈为空则返回null
     */
    E peek();


    /**
     * 返回栈中元素个数
     */
    int size();
}
