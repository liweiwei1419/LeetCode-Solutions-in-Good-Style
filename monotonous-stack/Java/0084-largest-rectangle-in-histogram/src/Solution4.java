import java.util.Stack;

public class Solution4 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        // 2 个哨兵
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 添加哨兵 1：它永远在
        newHeights[0] = -1;
        // 添加哨兵 2：它进去了也没有机会出来了
        newHeights[len + 1] = 0;

        // 为了易于编码，将 heights 指向 newHeights
        heights = newHeights;
        len += 2;

        Stack<Integer> stack = new Stack<>();

        int maxAres = 0;
        for (int i = 0; i < len; i++) {
            // 注意：这里是 while
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int currentIndex = stack.pop();
                // 因为有 -1 在 stack.peek() 永远非空
                int width = i - stack.peek() - 1;;
                maxAres = Math.max(maxAres, heights[currentIndex] * width);
            }
            stack.push(i);
        }
        return maxAres;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Solution4 solution4 = new Solution4();
        int res = solution4.largestRectangleArea(heights);
        System.out.println(res);
    }
}


