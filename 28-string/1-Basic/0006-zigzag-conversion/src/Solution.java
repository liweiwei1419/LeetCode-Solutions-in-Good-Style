public class Solution {

    public String convert(String s, int numRows) {
        // 特判
        if (numRows < 2) {
            return s;
        }

        // 每一行初始化，每一行相当于一个链表
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int len = s.length();
        int index = 0;
        // 遍历每一个字符
        while (index < len) {
            // 先从上到下
            for (int i = 0; i < numRows && index < len; i++) {
                rows[i].append(s.charAt(index));
                index++;
            }
            // 再从下到上
            for (int i = numRows - 2; i > 0 && index < len; i--) {
                rows[i].append(s.charAt(index));
                index++;
            }
        }

        // 最后合起来
        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution solution = new Solution();
        String convert = solution.convert(s, numRows);
        System.out.println(convert);
    }
}
