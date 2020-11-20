public class Solution2 {

    public static final int TARGET = 24;
    public static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] nums) {
        int len = nums.length;
        double[] copyNum = new double[len];
        for (int i = 0; i < len; i++) {
            copyNum[i] = nums[i];
        }
        return dfs(copyNum);
    }

    private boolean dfs(double[] candidate) {
        int len = candidate.length;
        if (len == 1) {
            return Math.abs(candidate[0] - TARGET) < EPSILON;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 下一轮搜索，总的数字减少了 1 个，每一次传下去都是新的，所以不用回溯
                double[] newCandidate = new double[len - 1];
                for (int k = 0, index = 0; k < len; k++) {
                    if (k != i && k != j) {
                        newCandidate[index] = candidate[k];
                        index++;
                    }
                }

                // 一共 6 种结果
                double[] results = compute(candidate[i], candidate[j]);
                for (double result : results) {
                    newCandidate[newCandidate.length - 1] = result;
                    if (dfs(newCandidate)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double i, double j) {
        // 注意：减法和除法有顺序性
        return new double[]{i + j, i - j, j - i, i * j, i / j, j / i};
    }
}