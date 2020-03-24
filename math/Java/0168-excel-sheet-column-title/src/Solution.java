/**
 * @author liwei
 * @date 18/7/5 下午10:45
 */
public class Solution {

    // 原理和进制转换是一样的

    private static final int OFFSET = 'A';

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--;
            stringBuilder.append((char) (n % 26 + OFFSET));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i <= 30; i++) {
            String convertToTitle = solution.convertToTitle(i);
            System.out.println(convertToTitle);
        }
    }
}
