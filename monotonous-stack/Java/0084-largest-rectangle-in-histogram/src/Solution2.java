import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/23 6:28 PM
 */
public class Solution2 {

    // 单调栈里面存的是索引
    // 根据题意，利用好栈的特性，正好栈里面元素呈现的性质是（严格）单调的，

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        List<Integer> heightsArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            heightsArr.add(heights[i]);
        }
        // 这里 -1 换成 0 也是可以的
        heightsArr.add(-1);

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 注意这里是等于 i <= len;
        for (int i = 0; i <= len; i++) {
            // 严格小于的时候，才弹栈结算
            while (!stack.isEmpty() && heightsArr.get(stack.peek()) > heightsArr.get(i)) {
                int left = stack.pop();

                // 这一步要小心，如果弹出以后，栈是空的，那说明，刚刚弹出的就是目前看到的所有高度里最小的
                if (!stack.isEmpty()) {
                    res = Math.max(res, heightsArr.get(left) * (i - stack.peek() - 1));
                } else {
                    res = Math.max(res, heightsArr.get(left) * i);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Solution2 solution2 = new Solution2();
        int res = solution2.largestRectangleArea(heights);
        System.out.println(res);
    }
}
