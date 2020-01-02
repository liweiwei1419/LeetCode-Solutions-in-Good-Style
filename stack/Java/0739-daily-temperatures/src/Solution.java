import java.util.Arrays;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/11/2 9:35 上午
 */
public class Solution {

    public int[] dailyTemperatures(int[] T) {
        // int[] 存储每个温度以及其在数组T中的下标
        Stack<int[]> stack = new Stack<>();
        int len = T.length;

        int[] res = new int[len];
        // 温度依次入栈，栈内元素保持单调减少
        // 用于发现第一次升高温度
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && T[i] > stack.peek()[0]) {
                // 如果遇到高温
                // 如果当前温度比栈顶高，那么就发现了相对于栈顶第一次升高温度的位置

                // 位置差即为答案
                res[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{T[i], i});
        }
        // 如果栈中还有数，默认都为零了
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] res = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
