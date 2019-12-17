import java.util.Arrays;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/12/3 11:25 上午
 */
public class Solution2 {

    // 时间复杂度：O(N)
    // 空间复杂度：O(N)

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        // 特判
        if (len < 2) {
            return new int[len];
        }
        int[] res = new int[len];

        // 1、存的是索引
        // 2、对应的值的特点，单调不减
        // 3、出栈的时候，记录 res
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            // 注意 1：根据题意，这里要写等于号
            // 注意 2：不能把 while 写成 if
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
