// 解释得很详细：还有具体的例子
// https://kingsfish.github.io/2017/12/15/Leetcode-421-Maximum-XOR-of-Two-Numbers-in-an-Array/

public class Solution {

    // 暴力解法：如何求一个数组中任意两个元素作用的结果
    // 居然可以通过测试

    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        int res = 0;
        // i 到 len -2 就可以了
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        for (int num: nums) {
            System.out.println(Integer.toBinaryString(num));
        }
        System.out.println(28);
        Solution solution = new Solution();
        int maximumXOR = solution.findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }
}
