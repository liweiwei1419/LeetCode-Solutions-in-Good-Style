public class Solution2 {

    public String removeKdigits(String num, int k) {
        int n;
        while (true) {
            n = num.length();
            if (n <= k || n == 0) {
                return "0";
            }
            if (k == 0) {
                return num;
            }
            k--;
            if (num.charAt(1) == '0') {
                int firstNonZero = 1;
                while (firstNonZero < num.length() && num.charAt(firstNonZero) == '0') {
                    firstNonZero++;
                }
                num = num.substring(firstNonZero);
            } else {
                int startIndex = 0;
                while (startIndex < num.length() - 1 && num.charAt(startIndex) <= num.charAt(startIndex + 1)) {
                    startIndex++;
                }
                num = num.substring(0, startIndex) + num.substring(startIndex + 1);
            }
        }
    }
}
