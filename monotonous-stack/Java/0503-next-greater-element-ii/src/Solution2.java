import java.util.Arrays;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/12/3 5:07 下午
 */
public class Solution2 {

    public int[] nextGreaterElements(int[] nums) {
        int len1 = nums.length;

        // 拼接循环数组，这是常用技巧
        int len2 = len1 << 1;
        int[] numsCirculate = new int[len2];
        System.arraycopy(nums, 0, numsCirculate, 0, len1);
        System.arraycopy(nums, 0, numsCirculate, len1, len1);

        // 初始化为 -1 的原因：在遍历终止的时候，栈中还存在的那些元素表示它们的右边没有比它大的元素
        int[] res = new int[len2];
        Arrays.fill(res, -1);

        // 存的应该是索引
        // 如果新来的数小于等于栈顶，就添加，如果严格大于，就弹栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len2; i++) {

            while (!stack.isEmpty() && numsCirculate[stack.peek()] < numsCirculate[i]) {
                int index = stack.pop();
                res[index] = numsCirculate[i];
            }
            stack.push(i);
        }

        // 只要前一半即可
        int[] newRes = new int[len1];
        System.arraycopy(res, 0, newRes, 0, len1);
        return newRes;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
