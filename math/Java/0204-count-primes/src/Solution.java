public class Solution {

    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (nums[i]) {
                for (int j = 2; i * j < n; j++) {
                    nums[i * j] = false;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]) {
                res++;
            }
        }
        return res;
    }
}
