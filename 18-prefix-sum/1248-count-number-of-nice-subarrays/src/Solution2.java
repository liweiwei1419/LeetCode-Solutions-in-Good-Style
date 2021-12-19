public class Solution2 {

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] odd = new int[len + 2];
        int ans = 0, cnt = 0;
        for (int i = 0; i < len; ++i) {
            if ((nums[i] & 1) != 0) {
                cnt++;
                odd[cnt] = i;
            }
        }
        odd[0] = -1;
        cnt++;
        odd[cnt] = len;
        for (int i = 1; i + k <= cnt; ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}