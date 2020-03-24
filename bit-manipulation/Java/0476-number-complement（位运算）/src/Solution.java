public class Solution {

    /**
     * 使用 Java 库函数 Integer.toBinaryString() 将一个整数转换为二进制字符串表示
     * @param num
     * @return
     */
    public int findComplement(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("输入的数字不是正整数");
        }
        String numStr = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : numStr.toCharArray()) {
            if (c == '0') {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        numStr = stringBuilder.toString();
        return Integer.valueOf(numStr, 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int solutionComplement = solution.findComplement(n);
        System.out.println(solutionComplement);
    }
}
