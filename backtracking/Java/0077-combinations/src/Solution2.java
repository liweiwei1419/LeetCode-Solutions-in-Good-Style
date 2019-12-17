import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 特判
        if (n <= 0 && k <= 0 && k > n) {
            return result;
        }
        // 从 1 开始
        generateCombinations(n, k, 1, new ArrayList<>());
        return result;
    }

    /**
     * 从 [1,n] 中选出 k 个数，
     *
     * @param n     从 [1,n] 中选
     * @param k     选出的数字的个数
     * @param start 当前被选中的起始数字
     * @param pre   已经构成的数字列表
     */
    private void generateCombinations(int n, int k, int start, List<Integer> pre) {
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i <= n; i++) {
            pre.add(i);
            generateCombinations(n, k, i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<Integer>> combine = solution2.combine(4, 2);
        System.out.println(combine);
    }
}