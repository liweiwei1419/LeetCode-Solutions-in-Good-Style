/**
 * @author liwei
 * @date 2019/8/20 11:16 PM
 */
public class Solution7 {

    // 双指针，更具体的写法

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int res = 0;

        int leftMax = height[0];
        int rightMax = height[len - 1];

        // 注意初值的选取，前面做了特判，因此这里有效
        // 头和尾都不存雨水
        int left = 1;
        int right = len - 2;

        // 强调：这里是等于
        while (left <= right) {
            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " leftMax = " + leftMax + " rightMax = " + rightMax+ " res = " + res );

            int minVal = Math.min(leftMax, rightMax);
            if (minVal == leftMax) {
                if (minVal > height[left]) {
                    res += minVal - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (minVal > height[right]) {
                    res += minVal - height[right];
                }

                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // int[] height = new int[]{2,0,2};
        Solution7 solution4 = new Solution7();
        int res = solution4.trap(height);
        System.out.println(res);
    }
}
