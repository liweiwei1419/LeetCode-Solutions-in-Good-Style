import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {

    // 方法二：广度优先遍历

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        // 总共需要拼凑的字符总数是 2 * n
        n = 2 * n;

        while (n > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if (curNode.left > 0) {
                    queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                }
                if (curNode.right > 0 && curNode.left < curNode.right) {
                    queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
                }
            }
            n--;
        }

        // 最后一层就是题目要求的结果集
        while (!queue.isEmpty()) {
            res.add(queue.poll().res);
        }
        return res;
    }

    private class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "res='" + res + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}