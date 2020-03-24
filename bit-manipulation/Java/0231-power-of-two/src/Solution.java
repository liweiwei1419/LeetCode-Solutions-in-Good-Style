public class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfTwo = solution.isPowerOfTwo(4);
        System.out.println(powerOfTwo);
    }
}
