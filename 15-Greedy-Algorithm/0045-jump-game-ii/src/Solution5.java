public class Solution5 {

    // https://www.cnblogs.com/grandyang/p/4373533.html
    // https://www.youtube.com/watch?v=TTxJqe0htnA&ab_channel=FLAGeek%E5%AE%98%E6%96%B9%E9%A2%91%E9%81%93

    public int jump(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return 0;
        }

        int minStep = 0;

        // 上一步能到达的最远位置
        int currentEnd = 0;
        // maxReached 是当前能到达的最远位置
        int maxReached = 0;
        for (int i = 0; i < len - 1; i++) {
            maxReached = Math.max(maxReached , i + nums[i]);

            if (i == currentEnd){
                minStep++;
                currentEnd = maxReached;

                // 这一步可以不要
                if (maxReached >= len - 1){
                    break;
                }
            }
        }
        return minStep;
    }
}
