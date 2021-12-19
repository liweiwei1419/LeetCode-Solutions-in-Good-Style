public class Solution {

    public String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();

        char[] charArr = new char[]{' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        for (int i = 0; i < len; i++) {
            if (i + 2 < len && s.charAt(i + 2) == '#') {
                int index = Integer.parseInt(s.substring(i, i + 2));
                stringBuilder.append((char) (index + 96));
                i += 2;
            } else {
                stringBuilder.append(charArr[s.charAt(i) - '0']);
            }
        }
        return stringBuilder.toString();
    }
}