import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/16 2:49 PM
 */
public class Solution {

    // 参考资料：https://blog.csdn.net/lv1224/article/details/79974175
    // https://blog.csdn.net/qq_17550379/article/details/85093224
    // https://zhuanlan.zhihu.com/p/26465701

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;

        // 每一个元素都会进栈一次，出栈一次
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                // 后面的只要不比栈顶元素小，就入栈，注意：添加的是索引
                stack.push(i);
            } else {
                // 此时当前左边的第 1 个肯定比当前的高
                // 只声明即可，不用实例化
                int left;
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    // 如果新进来的矮，就考虑以当前栈顶为高度最大能是多少
                    // left 是相对当前 i 而言
                    left = stack.pop();
                    // 注意：弹出一个以后，再看看左边，如果没有的话，i 就是矩形的长度
                    // 当前矩形的长度
                    int curLong;
                    if (!stack.isEmpty()) {
                        // 当前的长度
                        curLong = i - stack.peek() - 1;
                    } else {
                        curLong = i;
                    }
                    res = Math.max(res, curLong * heights[left]);
                }
                stack.push(i);
            }
        }

        // 注意：这个过程还要执行一次，优化的方法是，在 heights 后面加一个 -1
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int curLong;
            if (!stack.isEmpty()) {
                curLong = len - stack.peek() - 1;
            } else {
                // 此时 i 已经到了 len 这个部分，因此这部分操作和上面是完全一样的
                // 只有一个元素的时候，此时高度是全部矩形里面最矮的，因此是 len
                curLong = len;
            }
            res = Math.max(res, curLong * heights[left]);
        }
        return res;
    }
}
