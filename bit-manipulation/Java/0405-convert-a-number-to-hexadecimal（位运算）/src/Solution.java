public class Solution {

    /**
     * 索引到字符的映射表，实现了类似字典的功能
     */
    private static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 15 的二进制表示就是 1111
     */
    private static final int MASK = 15;

    public String toHex(int num) {
        // 注意点 1：对于 0 的特殊处理
        if (num == 0) {
            return "0";
        }
        StringBuilder hex = new StringBuilder();
        // 注意点 2：如果高位已经是 0 ，就不必再拼接 0 了，这是题目中的要求
        for (int i = 0; i < 8 && num != 0; i++) {
            // 取最低 4 位，进行转换
            hex.insert(0, map[num & MASK]);
            // 无符号右移 4 位
            // 10001011
            num >>>= 4;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 16;
        String toHex = solution.toHex(num);
        System.out.println(toHex);
        System.out.println(-1);
    }
}
