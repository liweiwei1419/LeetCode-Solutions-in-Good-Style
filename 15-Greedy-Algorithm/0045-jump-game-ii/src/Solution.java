public class Solution {

    // 从前向后，只关心最远值，时间复杂度：O(N)

    // 有点像广度优先遍历

    public int jump(int[] nums) {
        int len = nums.length;
        int currMaxReached = 0;
        int nextMaxReached = 0;
        int res = 0;

        // 最后一个位置不用看
        for (int i = 0; i < len - 1; i++) {
            nextMaxReached = Math.max(nextMaxReached, nums[i] + i);
            if (i == currMaxReached) {
                // 遇到这一步可以到达的最远边界，就更新为下一步可以达到的最远边界，并且步数加一
                currMaxReached = nextMaxReached;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 2, 3};
        int res = solution.jump(nums);
        System.out.println(res);
    }
}