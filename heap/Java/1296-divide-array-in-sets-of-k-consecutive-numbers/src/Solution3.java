import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        int k = 4;


        Solution3 solution3 = new Solution3();
        boolean res = solution3.isPossibleDivide(nums, k);
        System.out.println(res);
    }
}


