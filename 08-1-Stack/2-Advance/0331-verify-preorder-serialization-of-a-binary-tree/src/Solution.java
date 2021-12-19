import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // # 代表一个空节点
    // 参考：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/zhong-gui-zhong-ju-pan-duan-you-xiao-shu-kr64/

    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");
        int len = splits.length;

        // 特判
        if (len == 1 && "#".equals(splits[0])) {
            return true;
        }

        // 因为空子树需要表示
        if (len < 3) {
            return false;
        }

        // 还没想清楚
        if (!"#".equals(splits[len - 1]) && !"#".equals(splits[len - 2])) {
            return false;
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push(splits[0]);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && "#".equals(stack.peekLast())) {
                stack.removeLast();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
            stack.addLast(splits[i]);
        }
        return !stack.isEmpty() && "#".equals(stack.peekLast());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String preorder = "1,#";
        boolean res = solution.isValidSerialization(preorder);
        System.out.println(res);
    }
}