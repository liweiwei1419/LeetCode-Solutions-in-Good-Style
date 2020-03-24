public class Solution3 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 111221 previous
        // 小技巧：加上一个结束标记，可以避免很多讨论
        String preStr = countAndSay(n - 1) + "#";
        int len = preStr.length();
        StringBuilder stringBuilder = new StringBuilder();
        int duplicateTimes = 1;
        for (int i = 0; i < len - 1; i++) {
            if (preStr.charAt(i) == preStr.charAt(i + 1)) {
                duplicateTimes++;
            } else {
                stringBuilder.append(duplicateTimes);
                stringBuilder.append(preStr.charAt(i));
                duplicateTimes = 1;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String countAndSay = solution3.countAndSay(6);
        System.out.println(countAndSay);
    }
}
