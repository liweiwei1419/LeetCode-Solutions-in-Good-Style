public class Solution {

    // 使用递归的写法，要特别注意大整数溢出的情况

    public int integerReplacement(int n) {
        return longReplacement(n);
    }

    private int longReplacement(long n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n % 2 == 0) {
            return longReplacement(n / 2) + 1;
        }
        return 1 + Math.min(longReplacement(n + 1), longReplacement(n - 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = Integer.MAX_VALUE;
        int integerReplacement = solution.integerReplacement(n);
        System.out.println(integerReplacement);
    }
}
