import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution2 {

    // 时间复杂度：O(N)
    // 空间复杂度：O(N)

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len < 2) {
            return new int[len];
        }

        int[] res = new int[len];
        // 栈里存下标；对应的值的特点，单调不增；出栈的时候，记录 res
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                int index = stack.removeLast();
                res[index] = i - index;
            }
            stack.addLast(i);
        }

        // 最后在栈里的元素保持单调不增，因此下面这三行代码可以省略
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
