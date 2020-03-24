/**
 * @author liwei
 * @date 18/6/29 下午8:43
 */
public class Solution2 {

    public boolean hasAlternatingBits(int n) {
        String nStr = Integer.toBinaryString(n);
        int len = nStr.length();
        for (int i = 0; i < len - 1; i++) {
            if (nStr.charAt(i) == nStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int n = 5;
        solution2.hasAlternatingBits(n);
    }
}
