public class Solution3 {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if ((len % k) != 0) {
            return false;
        }

        int size = len / k;
        int[] cnt = new int[k];

        for (int i = 0; i < len; i++) {
            cnt[nums[i] % k]++;
        }

        for (int i = 0; i < k; i++) {
            if (cnt[i] != size) {
                return false;
            }
        }
        return true;
    }
}