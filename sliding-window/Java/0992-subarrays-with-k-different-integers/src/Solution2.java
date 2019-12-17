/**
 * @author liweiwei1419
 * @date 2019/10/11 11:48 下午
 */
public class Solution2 {

    // 较难理解

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
        while (right < len) {

            hash[A[right]]++;
            if (hash[A[right]] == 1) {
                count++;
            }
            right++;

            // 左边界可以前进条件：
            // 1、左边的字符出现的次数大于 1；
            // 2、总的不同的字符数大于 K；
            // 因为左边界前进一格都还满足 count == K
            while (hash[A[left]] > 1 || count > K) {
                if (count > K) {
                    // 重置
                    cur = 1;
                    count--;
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

    public static void main(String[] args) {

        int[] A = {2,2,1,2,2,2,1,1};
        int K = 2;
        Solution2 solution = new Solution2();
        int res = solution.subarraysWithKDistinct(A, K);
        System.out.println(res);
    }
}
