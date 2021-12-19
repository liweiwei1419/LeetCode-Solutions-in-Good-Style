public class Solution2 {

    // 贪心算法

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 从下标 0 开始的「累计剩余油量」
        int rest = 0;
        // 从 start + 1 开始的「累计剩余油量」
        int run = 0;
        // 输出结果
        int start = 0;

        int len = gas.length;
        for (int i = 0; i < len; i++) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }

        if (rest < 0) {
            return -1;
        }
        return start;
    }
}