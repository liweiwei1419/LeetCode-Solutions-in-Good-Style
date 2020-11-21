public class Solution {

    // 超时

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = sum(A, i, j);
                if ((sum % K) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int sum(int[] A, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += A[i];

        }
        return sum;
    }
}