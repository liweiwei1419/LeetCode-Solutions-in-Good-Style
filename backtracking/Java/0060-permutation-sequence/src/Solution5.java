import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/19 5:50 上午
 */
public class Solution5 {

    // https://leetcode-cn.com/problems/permutation-sequence/solution/cong-gao-dao-di-que-ding-mei-yi-wei-shu-zi-java2ms/

    // 阶乘值要经常用，还是记住比较好

    private int factorial(int x) {
        int res = 1;
        for (int i = 1; i <= x; i++) {
            res = res * i;
        }
        return res;
    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        int index;
        int loopTimes = n;
        for (int i = 0; i < loopTimes; ++i) {
            --n;
            index = (k - 1) / factorial(n);
            // System.out.println(nums);
            // System.out.println("index = " + index);
            stringBuilder.append(nums.remove(index));
            k -= index * factorial(n);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int n = 4;
        int k = 9;
        String res = solution5.getPermutation(n, k);
        System.out.println(res);
    }
}
