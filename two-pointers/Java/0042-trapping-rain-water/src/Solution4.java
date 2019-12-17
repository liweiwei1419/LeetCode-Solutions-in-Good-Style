public class Solution4 {

    // 双指针

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int res = 0;

        int leftMax = 0;
        int rightMax = 0;
        // 注意初值的选取
        int left = 0;
        int right = len - 1;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution4 solution4 = new Solution4();
        int res = solution4.trap(height);
        System.out.println(res);
    }
}
