import java.util.TreeSet;

class Node implements Comparable<Node>{
    int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}

public class Main {

    public static void main(String[] args) {
        TreeSet<Node> treeSet = new TreeSet<>();
        Node node1 = new Node(1);
        treeSet.add(node1);
        Node node2 = new Node(2);
        treeSet.add(node2);
        Node node3 = new Node(3);
        treeSet.add(node3);
        System.out.println(treeSet);
        System.out.println(treeSet.remove(node2));
        node2.val = 100;
        treeSet.add(node2);
        System.out.println(treeSet);
    }
}
