public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.insert("T");
        t.insert("C");
        t.insert("A");
        t.insert("B");
        t.insert("Q");
        t.insert("V");
        t.insert("Z");
        t.insert("U");
        t.preorder();
    }

    // null for an empty tree
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(String label) {
        // Attaches nodeToInsert node To parent node
        // if isLeft is true, nodeToInsert is attached as a left child,
        // implement this method
        if (root == null) {
            root = new Node(label);
            return;
        }
        Node tmp = root;
        while (tmp != null) {
            if (label.compareTo(tmp.label) < 0) {
                if (tmp.left == null) {
                    tmp.left = new Node(label);
                    return;
                }
                else
                    tmp = tmp.left;
            }
            else {
                if (tmp.right == null) {
                    tmp.right = new Node(label);
                    return;
                }
                else
                    tmp = tmp.right;
            }
        }

    }

    public void preorder() {
        preorder(root);
    }
    public void preorder(Node n) {
        System.out.println(n.label);
        if (n.left != null) preorder(n.left);
        if (n.right != null) preorder(n.right);
    }

}

class Node {
    // implement this class
    public String label;
    public Node left;
    public Node right;

    public Node(String label) {
        this(label, null, null);
    }
    public Node(String label, Node left, Node right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }
}