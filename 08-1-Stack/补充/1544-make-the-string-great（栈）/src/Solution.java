public class Solution {

    public String makeGood(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            stringBuilder.append(charArray[i]);
            int currentLen = stringBuilder.length();
            if (currentLen < 2) {
                continue;
            }

            boolean condition1 = stringBuilder.charAt(currentLen - 1) + 32 == stringBuilder.charAt(currentLen - 2);
            boolean condition2 = stringBuilder.charAt(currentLen - 1) - 32 == stringBuilder.charAt(currentLen - 2);

            if (condition1 || condition2) {
                while (stringBuilder.length() > currentLen - 2) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leEeetcode";
        String res = solution.makeGood(s);
        System.out.println(res);
    }
}
