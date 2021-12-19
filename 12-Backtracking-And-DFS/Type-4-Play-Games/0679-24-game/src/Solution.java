import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 官方题解：https://leetcode-cn.com/problems/24-game/solution/24-dian-you-xi-by-leetcode-solution/
    public static final int TARGET = 24;
    public static final double EPSILON = 1e-6;

    /**
     * 加法和乘法满足交换律的必须在前面
     */
    public static final int ADD = 0;
    public static final int MULTIPLY = 1;
    public static final int SUBTRACT = 2;

    public boolean judgePoint24(int[] nums) {
        List<Double> candidate = new ArrayList<>();
        for (int num : nums) {
            candidate.add((double) num);
        }
        return dfs(candidate);
    }

    public boolean dfs(List<Double> candidate) {
        if (candidate.size() == 0) {
            return false;
        }
        if (candidate.size() == 1) {
            // 浮点数的计算要符合精度
            return Math.abs(candidate.get(0) - TARGET) < EPSILON;
        }
        int size = candidate.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                // 计算有先后顺序
                if (i != j) {
                    List<Double> newCandidate = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        // 在 i 和 j 都不等的情况下
                        if (k != i && k != j) {
                            newCandidate.add(candidate.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        // 加法和乘法有交换性，这里是剪枝
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            newCandidate.add(candidate.get(i) + candidate.get(j));
                        } else if (k == MULTIPLY) {
                            newCandidate.add(candidate.get(i) * candidate.get(j));
                        } else if (k == SUBTRACT) {
                            newCandidate.add(candidate.get(i) - candidate.get(j));
                        } else {
                            // 只能是除法
                            if (Math.abs(candidate.get(j)) < EPSILON) {
                                continue;
                            } else {
                                newCandidate.add(candidate.get(i) / candidate.get(j));
                            }
                        }
                        if (dfs(newCandidate)) {
                            return true;
                        }
                        newCandidate.remove(newCandidate.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}