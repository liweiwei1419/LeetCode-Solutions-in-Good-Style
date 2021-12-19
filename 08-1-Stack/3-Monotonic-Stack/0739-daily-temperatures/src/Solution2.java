import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    // 时间复杂度：O(N)
    // 空间复杂度：O(N)

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len < 2) {
            return new int[len];
        }

        int[] res = new int[len];
        // 栈里存下标；对应的值的特点，单调不增；出栈的时候，记录 res
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
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
}