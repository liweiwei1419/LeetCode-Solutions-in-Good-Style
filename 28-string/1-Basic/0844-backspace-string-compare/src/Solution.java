public class Solution {

    public boolean backspaceCompare(String S, String T) {
        String simplifyS = simplify(S);
        String simplifyT = simplify(T);
        return simplifyS.equals(simplifyT);
    }

    private String simplify(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char s : charArray) {
            if (s == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                continue;
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}