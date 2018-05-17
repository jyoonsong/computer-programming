import java.io.File;

public class LinkedListConsole{
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add(280);
        list.add(135);
        list.add(456);
        list.remove();
        System.out.println(list.get(1));

        File f = new File("out.txt");
        System.out.println(f.renameTo(new File("src/out.txt")));

        OptionalLinkedList l = new OptionalLinkedList();
        l.append(new ListNode("jaeyoon"));
        l.append(new ListNode("world"));
        l.append(new ListNode("haha"));
        l.rev();
        for (int i = 0; i < 3; i++)
            System.out.println(l.get(i));
        System.out.println(l.substring("hawor"));

        OptionalLinkedList l2 = new OptionalLinkedList();
        l2.append(new ListNode("yes"));
        ListNode foo = new ListNode("she", new ListNode("sells", new ListNode("seashells", new ListNode("on", new ListNode("the", new ListNode("seashore"))))));
        l2.append(foo);
        l2.append(new ListNode("haha"));
        for (int i = 0; i < 8; i++)
            System.out.println(l2.get(i));

    }
}

class LinkedIntList {

    // fields
    private ListIntNode front;
    // constructors
    public LinkedIntList() {
        front = null;
    }
    // methods
    public void add(int value) {
        ListIntNode newNode = new ListIntNode(value);
        if (front == null)
            front = newNode;
        else {
            ListIntNode curr = front;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public int get(int index) {
        ListIntNode curr = front;
        for (int i = 0; i < index; i++) { // curr != null ?
            curr = curr.next;
        }
        return curr.data;
    }
    public int remove() {
        int tmp = front.data;
        front = front.next;
        return tmp;
    }
}

class OptionalLinkedList {
    // fields
    private ListNode front;
    // constructors
    OptionalLinkedList() {
        front = null;
    }
    // methods
    public String get(int index) {
        ListNode curr = front;
        for (int i = 0; i < index; i++) { // curr != null ?
            curr = curr.next;
        }
        return curr.word;
    }
    public void append(ListNode r) {
        if (front == null) {
            front = r;
            return;
        }
        ListNode curr = front;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = r;
    }

    // check whether current linked list has substring s or not
    public boolean substring(String s) {
        ListNode curr = front;
        String str = "";
        while (curr != null) {
            str += curr.word;
            curr = curr.next;
        }
        return str.contains(s);
    }

    // reverses current linked list
    public void rev() {
        ListNode prev = null;
        ListNode curr = front;
        ListNode next;
        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        front = curr;
    }
}
