/**
 * @author liwei
 * @date 18/6/30 上午11:42
 */
public class Solution3 {

    // 当前写法错误
    // 转换成 8 进制
    public String toOctalString(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8 && num != 0; i++) {
            // 111 = 1 + 2 + 4

            stringBuilder.insert(0, num & 7);
            num >>>= 3;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        Solution3 solution3 = new Solution3();
        for (int i = -1; i < 10000; i++) {
            String num1 = Integer.toOctalString(i);
            String num2 = solution3.toOctalString(i);
            if (!num1.equals(num2)) {
                System.out.println(i);
                System.out.println(num1);
                System.out.println(num2);
                throw new RuntimeException("二进制转换出错！");
            }
        }
        System.out.println("正确！");
    }
}
