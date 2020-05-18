import java.util.Stack;

public class Solution3 {

    // 不推荐

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] newHeights = new int[len + 1];
        System.arraycopy(heights, 0, newHeights, 0, len);
        // 添加哨兵
        newHeights[len] = 0;

        // 为了易于编码，将 heights 指向 newHeights
        heights = newHeights;
        len++;

        Stack<Integer> stack = new Stack<>();

        int maxAres = 0;
        for (int i = 0; i < len; i++) {
            // 注意：这里是 while
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int currentIndex = stack.pop();

                // 要用 stack.peek() 前提是栈为空
                int width;
                if (stack.isEmpty()) {
                    // 画图分析
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxAres = Math.max(maxAres, heights[currentIndex] * width);
            }
            stack.push(i);
        }

        return maxAres;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Solution3 solution3 = new Solution3();
        int res = solution3.largestRectangleArea(heights);
        System.out.println(res);
    }
}


