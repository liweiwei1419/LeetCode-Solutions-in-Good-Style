public class Solution3 {

    // 方法：贪心算法：类似层序遍历，脑子里要形成一个动画

    public int jump(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return 0;
        }

        // 当前区间的结束下标
        int currentEnd = 0;
        // [0, i) 里能达到的最远下标
        int maxReached = 0;
        int steps = 0;
        for (int i = 0; i < len - 1; i++) {
            maxReached = Math.max(maxReached, i + nums[i]);
            if (i == currentEnd) {
                currentEnd = maxReached;
                steps++;
            }

        }
        return steps;
    }
}
