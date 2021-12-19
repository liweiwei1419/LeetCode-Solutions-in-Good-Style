import java.util.Stack;

public class Solution6 {

    // 方法四：单调栈
    // 考虑每个位置左边和右边第一个比它高的位置的矩形条，以及三个矩形条构成的 U 型
    // 类比问题：LeetCode 第 11 题，LeetCode 第 239 题，存的是下标

    // 这个是哨兵的写法，不推荐

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }
        int res = 0;
        // 单调栈里面存的是索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            // 最后一层的水平线，因为加法是一层一层加上去的
            int last = 0;
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                // 挨得近的第 1 次一般是加 0
                res += (i - top - 1) * (height[top] - last);
                // top 变成目前最低水位
                last = height[top];
            }
            // 重点理解这句话的意思
            if (!stack.empty()) {
                res += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return res;
    }
}