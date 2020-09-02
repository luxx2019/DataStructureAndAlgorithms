package queue;

import beans.Employee;

public class CircleArrayQueueTest {

    public static void main(String[] args) {

        Queue<Employee> queue = new CircleArrayQueue<>();

        Employee e1 = new Employee("张三风", 15);
        Employee e2 = new Employee("李成功", 27);
        Employee e3 = new Employee("张玉华", 18);

        System.out.println(queue.peek());
        System.out.println(queue.pop());

        queue.push(e1);
        queue.push(e2);
        queue.push(e3);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
