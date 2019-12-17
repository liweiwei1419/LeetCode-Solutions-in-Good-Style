/**
 * @author liweiwei1419
 * @date 2019/10/11 11:48 下午
 */
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
        while (right < len) {
            hash[A[right]]++;
            if (hash[A[right]] == 1) {
                count++;
            }
            right++;
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

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4};
        int K = 3;
//        int[] A = {1, 2, 1, 2, 3};
//        int K = 2;
        Solution solution = new Solution();
        int res = solution.subarraysWithKDistinct(A, K);
        System.out.println(res);
    }
}
