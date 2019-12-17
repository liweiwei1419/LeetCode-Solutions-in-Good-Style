import java.util.ArrayList;
import java.util.List;


public class Solution4 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
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
     * @param pre   已经构成的数字数组
     */
    private void generateCombinations(int n, int k, int start, List<Integer> pre) {
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i <= n - (k - pre.size()) + 1; i++) {
            pre.add(i);
            generateCombinations(n, k, i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        List<List<Integer>> combine = solution4.combine(4, 2);
        System.out.println(combine);
    }
}