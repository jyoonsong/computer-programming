public class ListIntNode {
    int data;
    ListIntNode next;

    public ListIntNode(int data) {
        this(data, null);
    }
    public ListIntNode(int data, ListIntNode next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return "" + this.data;
    }
}

class ListNode {
    String word;
    ListNode next;

    public ListNode(String word) {
        this(word, null);
    }
    public ListNode(String word, ListNode next) {
        this.word = word;
        this.next = next;
    }

}