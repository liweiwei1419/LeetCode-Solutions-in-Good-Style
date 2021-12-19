public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }

        // 循环不变量：nums[0..j] 是有序的，并且相同元素最多保留 2 次
        // j 已经赋值过的元素的最后一个位置
        int j = 1;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[j - 1]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}