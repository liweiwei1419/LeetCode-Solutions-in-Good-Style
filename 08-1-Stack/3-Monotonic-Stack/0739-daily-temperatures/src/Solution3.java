import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;

        int[] newT = new int[len + 1];
        newT[0] = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            newT[i + 1] = T[i];
        }

        int[] res = new int[len];
        T = newT;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        // 注意有效位置从 1 开始
        for (int i = 1; i <= len; i++) {
            // 由于有哨兵结点在，查看栈顶元素的时候不用判空
            while (T[stack.peekLast()] < T[i]) {
                Integer top = stack.removeLast();
                res[top - 1] = i - top;
            }
            stack.addLast(i);
        }
        return res;
    }
}