public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {

            int num = n % 10;

            sum += num;
            product *= num;

            n /= 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        int n = 4421;
        Solution solution = new Solution();
        int res = solution.subtractProductAndSum(n);
        System.out.println(res);
    }
}
