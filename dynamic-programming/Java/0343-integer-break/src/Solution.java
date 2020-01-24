// 自顶向下记忆化搜索，即加入了记忆化搜索的递归解法
// https://leetcode-cn.com/problems/integer-break/description/
public class Solution {

    private int[] cache;

    // 将 n 进行分割（至少分割成两个部分），可以获得乘积的最大值
    private int maxBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int max = 0; // 这个初始值可以设置为 0 吗，1 行不行？
        for (int i = 1; i < n - 1; i++) {
            // 这里有一个陷阱，就是不能忽略不能继续分割的情况
            // 关键之处：状态转移方程，其中 i * (num - i) 这一步很关键，千万不能漏掉
            max = max3(i * maxBreak(n - i), i * (n - i), max);
        }
        max = Integer.max(max, n - 1);
        cache[n] = max;
        return max;
    }

    private int max3(int a, int b, int c) {
        return Integer.max(Integer.max(a, b), c);
    }

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        cache = new int[n + 1];
        return maxBreak(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int maxBreak = s.integerBreak(10);
        System.out.println(maxBreak);
    }
}
