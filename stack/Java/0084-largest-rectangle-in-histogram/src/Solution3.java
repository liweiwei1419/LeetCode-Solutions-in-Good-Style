import java.util.Stack;

public class Solution3 {

    // 使用哨兵的写法

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        // 最后一个 0 类似于哨兵，为了将栈中的元素全部清空
        int[] newHeights = new int[len + 1];
        System.arraycopy(heights, 0, newHeights, 0, len);
        newHeights[len] = 0;

        // 注意：为了避免编码出错，将 heights 指向新的 newHeights
        heights = newHeights;

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        // 注意：for 循环里面是小于等于，即 i <= len
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                // top 所在的柱形的最大高度可以确定
                int top = stack.pop();
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                res = Math.max(res, heights[top] * width);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution3 solution3 = new Solution3();
        int res = solution3.largestRectangleArea(heights);
        System.out.println(res);
    }
}
