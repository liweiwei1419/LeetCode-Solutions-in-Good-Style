public class NumArray {

    // 前缀和思想：注意：有一个单位的偏移

    private int[] preSum;

    public NumArray(int[] nums) {
        int len = nums.length;
        // 直接将原始数组变成前缀和数组
        preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        NumArray numArray = new NumArray(nums);
        int result = numArray.sumRange(2, 3);
        System.out.println(result);
    }
}
