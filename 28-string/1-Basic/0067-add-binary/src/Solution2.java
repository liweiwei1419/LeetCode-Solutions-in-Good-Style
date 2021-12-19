public class Solution2 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 保存结果的可变的字符序列对象
        StringBuilder res = new StringBuilder();
        // 当前和
        int curSum;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // 当前和至少是那个进位
            curSum = carry;
            if (i >= 0) {
                curSum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                curSum += b.charAt(j) - '0';
                j--;
            }

            // 判断是否需要进位，即确定 carry 的值
            if (curSum > 1) {
                curSum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }

            // 只写结果的值，进位作为下一轮的初始值
            res.insert(0, curSum);
        }

        // 这里不要忘记如果全部加完以后还要进位，要把最高位加上 1
        if (carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}