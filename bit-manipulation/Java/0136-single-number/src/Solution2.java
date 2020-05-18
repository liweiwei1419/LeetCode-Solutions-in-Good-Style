public class Solution2 {

    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new RuntimeException("数组元素为空，没有只出现一次的数字");
        }
        
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
