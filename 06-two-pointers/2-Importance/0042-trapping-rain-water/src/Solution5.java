import java.util.ArrayDeque;
import java.util.Deque;

public class Solution5 {

    // 方法四：栈（单调栈）

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int res = 0;

        // 单调栈里面存的是索引
        // 根据官方对 Stack 的使用建议，这里将 Deque 对象当做 stack 使用，注意只使用关于栈的接口
        // 由于实现类是数组 `ArrayDeque`，因此只能在末尾添加和删除元素
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();

                // 特殊情况，当栈为空的时候，跳出循环，直接增加当前下标 i 到栈里
                if (stack.isEmpty()) {
                    break;
                }

                int currentWidth = i - stack.peek() - 1;
                int currentHeight = Math.min(height[i], height[stack.peek()]) - height[top];

                res += currentWidth * currentHeight;
            }
            stack.push(i);
        }
        return res;
    }
}