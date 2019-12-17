import java.util.ArrayList;

/**
 * @author liweiwei1419
 * @date 2019/10/19 5:50 上午
 */
public class Solution4 {

    /**
     * 时间复杂度：O(N)，这里 N 是集合的大小
     * 空间复杂度：O(N)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        // 因为题目从 1 开始计数所以 k 先减一
        k -= 1;

        int[] factorial = new int[n];
        factorial[0] = 1;
        // 先算出所有的阶乘值
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        ArrayList<Integer> nums = new ArrayList<>();
        // 留一个空位给 0
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder res = new StringBuilder();
        //总共 n 位所以循环 n 次
        for (int j = n - 1; j >= 0; j--) {
            // System.out.println(nums);
            // 确定每一位应该是剩余数字中的第几个，偏移量是 1
            int index = k / factorial[j] ;
            // 每次实际使用的数字是集合中的第 index 个数字
            res.append(nums.remove(index));
            // 因为之前加 1 ，这里就要减 1
            k -= index * factorial[j];
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int n = 1;
        int k = 1;
        String res = solution4.getPermutation(n, k);
        System.out.println(res);
    }
}
