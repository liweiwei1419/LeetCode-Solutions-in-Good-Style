```java
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int len = str.length();
        int index = 0;
        if (len == 0) {
            return 0;
        }
        char signChar = str.charAt(0);
        long res = 0;
        int sign = 1;
        if (signChar == '+') {
            index++;
            sign = 1;
        } else if (signChar == '-') {
            index++;
            sign = -1;
        } else if (!Character.isDigit(signChar)) {
            return 0;
        }
        for (int i = index; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int cint = c - '0';
                res = res * 10 + cint;
                if (res * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (res * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        // 为了防止 long 类型越界，所以要在 遍历的时候检查是否溢出
        // "9223372036854775808"
        res = res * sign;
        return (int) res;
    }
}
```