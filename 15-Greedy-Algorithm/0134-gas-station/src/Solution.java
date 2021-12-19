public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diffSum = 0;
        int minDiffSum = Integer.MAX_VALUE;
        int start = 0;

        int len = gas.length;
        for (int i = 0; i < len; i++) {
            diffSum += gas[i] - cost[i];

            if (diffSum < minDiffSum) {
                minDiffSum = diffSum;
                start = i;
            }
        }

        if (diffSum < 0) {
            return -1;
        }
        return (start + 1) % len;
    }
}