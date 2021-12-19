import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // 最好加上私有访问权限
    // 泛型语法最好在实现类那里加上 <>，下面 Stack 实现类也一样哈

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // n <= 0 是多余的条件，只要有后面两个就行了
        if (n <= 0 || k <= 0 || n < k) {
            return list;
        }
        // 加上 <>
        helper(n, k, 1, new Stack<>());
        return list;
    }

    private void helper(int n, int k, int l, Stack<Integer> stack) {
        if (stack.size() == k) {
            // 加上 <>
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = l; i <= n; i++) {
            stack.add(i);
            // 这一步传入的是 i 不是 l，这里可能是笔误叭
            helper(n, k, i + 1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(n, k);
        System.out.println(res);
    }
}