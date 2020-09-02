package stack;

import beans.Employee;

public class LinkedStackTest {

    public static void main(String[] args) {

        Stack<Employee> stack = new LinkedStack<>();

        Employee e1 = new Employee("张三风", 15);
        Employee e2 = new Employee("李成功", 27);
        Employee e3 = new Employee("张玉华", 18);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.push(e1);
        stack.push(e2);
        stack.push(e3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
