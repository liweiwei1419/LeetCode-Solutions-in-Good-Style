public class Solution2 {

    // 区间和问题就要想到前缀和之差
    // 需要特别注意细节的问题
    // 依然超时

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;

        // preSum[i] 表示 [0, i) 的前缀和
        int[] preSum = new int[len + 1];
        preSum[0] = 0;

        // 区间 [i..j] 和 = preSum[j + 1] - preSum[i]
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (((preSum[j + 1] - preSum[i]) % K) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}