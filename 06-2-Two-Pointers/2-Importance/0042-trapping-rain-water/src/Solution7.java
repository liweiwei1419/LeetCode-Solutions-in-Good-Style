import java.util.ArrayDeque;
import java.util.Deque;

public class Solution7 {

    // 方法四：单调栈

    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        // 根据官方对 Stack 的使用建议，这里将 Deque 对象当做 stack 使用
        // 注意只使用关于栈的接口
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int level = 0;
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 此时说明有积水
                int top = stack.pop();
                int area = (i - top - 1) * (height[top] - level);
                res += area;
                level = height[top];
            }
            // 重点理解这句话的意思
            if (!stack.isEmpty()) {
                res += (i - stack.peek() - 1) * (height[i] - level);
            }
            stack.push(i);
        }
        return res;
    }
}