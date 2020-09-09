package list.circleLinkedList;
import java.util.Stack;

/**
 * 这里的循环链表是带头节点的写法
 */
public class CircleLinkedList {
    private Node head;

    public static void main(String[] args) {
        CircleLinkedList s = new CircleLinkedList();
        Node n1 = new Node(1, "宋江", "呼保义");
        Node n2 = new Node(7, "秦明", "霹雳火");
        s.addNode(n1);
        s.addNode(n2);
        s.addNode(1, "宋江", "呼保义");
        s.addNode(3, "吴用", "智多星");
        s.addNode(7, "秦明", "霹雳火");
        s.addNode(2, "卢俊义", "玉麒麟");
        s.addNode(10, "柴进", "小旋风");
        s.deleteNode(1);
        s.reverseList();

        s.printList();
    }

    // 构造函数，对头指针进行初始化
    CircleLinkedList() {
        Node n = new Node();
        n.next = n;
        head = n;
    }

    // 插入带信息的节点
    public void addNode(int no, String name, String nickname) {
        Node n = new Node(no, name, nickname);
        n.next = head.next;
        head.next = n;
    }

    // 将一个节点的复制插入到链表结尾，对上个函数的重载
    public void addNode(Node n) {
        addNode(n.no, n.name, n.nickname);
    }

    //根据排名删除某个节点，因为加入节点时，并没有检测排名相同的不能插入，所以删除时，要检测所有节点，删除匹配到的所有节点
    public void deleteNode(int no) {
        Node temp1 = head;
        Node temp2 = head.next;
        while (true) {
            if (temp2 == head)
                break;
            else if (temp2.no == no) {
                temp1.next = temp2.next;
                temp2 = temp2.next;
            }
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
    }

    // 修改节点信息，根据 no 找到需要修改的节点，更新信息，修改此 no 对应的所有信息，而非第一个
    public void changeNode(int no, int new_no, String new_name, String new_nickname) {
        Node temp = head.next;
        while (true) {
            if (temp == head)
                break;
            else if (temp.no == no) {
                temp.no = new_no;
                temp.name = new_name;
                temp.nickname = new_nickname;
                temp = temp.next;
            }
            else
                temp = temp.next;
        }
    }

    // 输出当前链表的全部信息
    public void printList() {
        Node temp = head.next;
        while (true) {
            if (temp == head)
                break;
            else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    // 反转当前单链表
    public void reverseList() {
        Stack<Node> st = new Stack<Node>();
        Node temp = head.next;
        while (true) {
            if (temp == head)
                break;
            st.push(temp);
            temp = temp.next;
        }
        Node n = new Node();
        n.next = n;
        head = n;
        while (!st.empty()) {
            addNode(st.pop());
        }
    }
}

class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;

    // 无参构造函数，因为定义了有参的构造函数时，默认无参构造函数就被覆盖掉了
    Node() {}

    // 包含信息的构造函数
    Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 重写toString()方法，方便打印节点信息
    public String toString() {
        return "[" + no + " " + name + " " + nickname + "]";
    }
}

