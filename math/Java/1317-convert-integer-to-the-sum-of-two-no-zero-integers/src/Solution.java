import java.util.Arrays;

public class Solution {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n - 1; i++) {
            if (containsZero(i) && containsZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

    private boolean containsZero(int num) {
        String numStr = num + "";
        return !numStr.contains("0");
    }

    public static void main(String[] args) {
        int n = 1010;
        Solution solution = new Solution();
        int[] res = solution.getNoZeroIntegers(n);
        System.out.println(Arrays.toString(res));
    }
}
