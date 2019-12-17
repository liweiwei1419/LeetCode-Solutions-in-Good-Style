import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/12/3 4:12 下午
 */
public class Solution2 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 对 nums2 先预处理
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
