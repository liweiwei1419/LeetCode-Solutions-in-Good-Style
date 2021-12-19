import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                // 作为底部支撑的那个柱形的下标
                Integer bottomIndex = stack.removeLast();
                // 出栈以后，如果栈为空，说明不能形成凹槽，此时跳过即可
                if (stack.isEmpty()) {
                    break;
                }

                int width = i - stack.peekLast() - 1;
                // 根据木桶原理，高度取决于，i 的高度和弹栈以后的新栈顶元素的高度
                int currentHeight = Math.min(height[stack.peekLast()], height[i]) - height[bottomIndex];
                area += (width * currentHeight);
            }
            // 栈中存下标
            stack.addLast(i);
        }
        return area;
    }
}