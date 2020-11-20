public class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        int len = A.length;
        if (len == 0 || len < K) {
            return 0;
        }
        // 0 那个位置我们浪费掉：1 <= A[i] <= A.length
        int[] hash = new int[len + 1];
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;

        int cur = 1;

        // [left, right]
        // 右边界向右
        while (right < len) {

            hash[A[right]]++;
            if (hash[A[right]] == 1) {
                count++;
            }
            right++;

            // 左边界向右，缩减到恰恰好 [left, right) 只有 K 的不同元素
            while (hash[A[left]] > 1 || count > K) {
                if (count > K) {
                    count--;
                    cur = 1;
                }
                if (hash[A[left]] > 1) {
                    cur++;
                }

                hash[A[left]]--;
                left++;
            }

            if (count == K) {
                res += cur;
            }
        }
        return res;
    }
}