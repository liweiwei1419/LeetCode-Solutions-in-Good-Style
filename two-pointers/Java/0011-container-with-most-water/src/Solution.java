/**
 * @author liwei
 * @date 2019/8/27 11:14 PM
 */
public class Solution {

    // 暴力解法，时间复杂度太高，我们应该使用指针对撞的方法

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        int res = solution.maxArea(height);
        System.out.println(res);
    }
}
