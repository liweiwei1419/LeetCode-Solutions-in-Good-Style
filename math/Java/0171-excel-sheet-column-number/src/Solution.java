public class Solution {

    // 利用 ASCII 码做一个偏移常量
    private static final int OFFSET = (int) 'A' - 1;

    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int curVal = s.charAt(i) - OFFSET;
            res = res * 26 + curVal;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(OFFSET);
        Solution solution = new Solution();
        String s = "ZY";
        int titleToNumber = solution.titleToNumber(s);
        System.out.println(titleToNumber);
    }
}
