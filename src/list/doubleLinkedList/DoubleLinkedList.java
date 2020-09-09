/*
 * shift + f6 : 批量修改变量名
 * 会改变包中所有的变量名，不仅是同一个类中的
 */

package list.doubleLinkedList;
import java.util.Stack;
public class DoubleLinkedList {
    private DoubleNode head = new DoubleNode();

    public static void main(String[] args) {
        DoubleLinkedList s = new DoubleLinkedList();
        DoubleNode n1 = new DoubleNode(1, "宋江", "呼保义");
        DoubleNode n2 = new DoubleNode(7, "秦明", "霹雳火");
        s.addNode(n1);
        s.addNode(n2);
        s.addNode(1, "宋江", "呼保义");
        s.deleteNode(1);
        s.addNode(3, "吴用", "智多星");
        s.addNode(7, "秦明", "霹雳火");
        s.addNode(2, "卢俊义", "玉麒麟");
        s.addNode(10, "柴进", "小旋风");
        s.reverseList();

        s.printList();
    }

    // 插入节点，采用尾插法
    public void addNode() {
        DoubleNode temp = head;
        while(true) {
            if (temp.next == null) {
                DoubleNode n = new DoubleNode();
                temp.next = n;
                n.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    // 插入带信息的节点，采用尾插法,对上个函数的重载
    public void addNode(int no, String name, String nickname) {
        DoubleNode temp = head;
        while(true) {
            if (temp.next == null) {
                DoubleNode n = new DoubleNode(no, name, nickname);
                temp.next = n;
                n.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    // 将一个节点的复制插入到链表结尾，对上个函数的重载
    public void addNode(DoubleNode n) {
        DoubleNode temp = head;
        DoubleNode n1 = new DoubleNode();
        n1.no = n.no;
        n1.name = n.name;
        n1.nickname = n.nickname;
        while(true) {
            if (temp.next == null) {
                temp.next = n1;
                n1.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    //根据排名删除某个节点
    //因为加入节点时，并没有检测排名相同的不能插入，所以删除时，要检测所有节点，删除匹配到的所有节点
    public void deleteNode(int no) {
        DoubleNode temp1 = head;
        DoubleNode temp2 = head.next;
        while (true) {
            if (temp2 == null)
                break;
            else if (temp2.no == no) {
                temp1.next = temp2.next;
                if (temp2.next != null) {
                    temp2.next.pre = temp1;
                }
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
        DoubleNode temp = head.next;
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
        DoubleNode temp = head.next;
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
        Stack<DoubleNode> st = new Stack<DoubleNode>();
        DoubleNode temp = head.next;
        while (true) {
            if (temp == null)
                break;
            st.push(temp);
            temp = temp.next;
        }
        head = new DoubleNode();
        while (!st.empty()) {
            addNode(st.pop());
        }
    }
}

class DoubleNode {
    public int no;
    public String name;
    public String nickname;
    public DoubleNode pre;
    public DoubleNode next;

    // 无参构造函数，因为定义了有参的构造函数时，默认无参构造函数就被覆盖掉了
    DoubleNode() {}

    // 包含信息的构造函数
    DoubleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 重写toString()方法，方便打印节点信息
    public String toString() {
        return "[" + no + " " + name + " " + nickname + "]";
    }
}
