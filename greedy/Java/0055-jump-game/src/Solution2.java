/**
 * @author liweiwei1419
 * @date 2019/10/15 10:30 上午
 */
public class Solution2 {

    /**
     * 从后向前走，避免了很多重复的计算
     * 最后一个位置一定为 true
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return false;
        }
        boolean[] check = new boolean[len];
        // 初始化的时候，设置为 true 表示可以到达
        check[len - 1] = true;
        for (int i = len - 1; i >= 0; i--) {
            int curStep = nums[i];
            for (int j = 0; j <= curStep; j++) {
                if (check[i + j]) {
                    check[i] = true;
                    break;
                }
            }
        }
        return check[0];
    }
}
