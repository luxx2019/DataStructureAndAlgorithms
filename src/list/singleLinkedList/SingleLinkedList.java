/*
 * 创建一个单链表，存储梁山好汉的信息
 * 信息包括排名、姓名、诨号
 * 此处代码为原创，并非搬运网课
 */

/*
 * == 和 equals() 的区别
 * == 和 equals() 本身并没有任何区别， Object 类当中， equals() 仍然是判断是否指向同一个对象
 * 但在实际操作中，我们经常重写 equals() 方法，用以判断两个对象的值是否相同
 * 当然，指向同一个对象也属于值相同
 */

package list.singleLinkedList;
import java.util.Stack;
public class SingleLinkedList {
    private Node head = new Node();

    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1, "宋江", "呼保义");
        Node n2 = new Node(7, "秦明", "霹雳火");
        s.addNode(n1);
        s.addNode(n2);
        s.addNode(1, "宋江", "呼保义");
        s.addNode(3, "吴用", "智多星");
        s.addNode(7, "秦明", "霹雳火");
        s.addNode(2, "卢俊义", "玉麒麟");
        s.addNode(10, "柴进", "小旋风");
        s.reverseList();

        s.printList();
    }

    // 插入节点，采用尾插法
    public void addNode() {
        Node temp = head;
        while(true) {
            if (temp.next == null) {
                Node n = new Node();
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
    }

    // 插入带信息的节点，采用尾插法,对上个函数的重载
    public void addNode(int no, String name, String nickname) {
        Node temp = head;
        while(true) {
            if (temp.next == null) {
                Node n = new Node(no, name, nickname);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
    }

    // 将一个节点的复制插入到链表结尾，对上个函数的重载
    public void addNode(Node n) {
        Node temp = head;
        Node n1 = new Node();
        n1.no = n.no;
        n1.name = n.name;
        n1.nickname = n.nickname;
        while(true) {
            if (temp.next == null) {
                temp.next = n1;
                break;
            }
            temp = temp.next;
        }
    }

    //根据排名删除某个节点
    //因为加入节点时，并没有检测排名相同的不能插入，所以删除时，要检测所有节点，删除匹配到的所有节点
    public void deleteNode(int no) {
        Node temp1 = head;
        Node temp2 = head.next;
        while (true) {
            if (temp2 == null)
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
            if (temp == null)
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
            if (temp == null)
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
            if (temp == null)
                break;
            st.push(temp);
            temp = temp.next;
        }
        head = new Node();
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