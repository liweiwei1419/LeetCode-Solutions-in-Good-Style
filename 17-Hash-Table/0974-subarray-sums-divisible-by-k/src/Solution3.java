public class Solution3 {

    // 哈希表

    public int subarraysDivByK(int[] A, int K) {
        // 前缀和出现的次数
        // key: i 之前的前缀和，value：出现的次数
        int[] preSumCount = new int[K];
        preSumCount[0] = 1;

        int preSum = 0;
        int res = 0;
        for (int value : A) {
            preSum += value;

            // (preSum % K + K) % K 这句话要解释清楚
            int remainder = (preSum % K + K) % K;
            int count = preSumCount[remainder];
            res += count;

            preSumCount[remainder]++;
        }
        return res;
    }
}