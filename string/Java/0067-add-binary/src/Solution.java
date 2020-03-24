public class Solution {

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);

        // 从个位开始加，个位在字符串的右边
        // 代码访问从左到右，因此先反转一下
        StringBuilder sbA = new StringBuilder(a).reverse();
        StringBuilder sbB = new StringBuilder(b).reverse();

        // 让两个字符补齐成一样的长度
        while (sbA.length() < maxLen) {
            sbA.append("0");
        }
        while (sbB.length() < maxLen) {
            sbB.append("0");
        }

        StringBuilder res = new StringBuilder();
        // 进位，初始时进位为 0
        int carry = 0;
        // 当前字符的 ASCII 值减去 '0' 的 ASCII 值，相当于将这个字符转换成数值
        int num1;
        int num2;
        for (int i = 0; i < maxLen; i++) {
            num1 = sbA.charAt(i) - '0';
            num2 = sbB.charAt(i) - '0';
            if (carry + num1 + num2 > 1) {
                // 因为是二进制，所以多余 2 的部分要减去
                res.append(carry + num1 + num2 - 2);
                // 表示要进位
                carry = 1;
            } else {
                res.append(carry + num1 + num2);
                carry = 0;
            }
        }
        // 对于最高位还要进位的情况，需要单独判断
        if (carry == 1) {
            res.append("1");
        }
        // 最后不要忘记再反转一次
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Solution solution = new Solution();
        String addBinary = solution.addBinary(a, b);
        System.out.println(addBinary);
    }
}
