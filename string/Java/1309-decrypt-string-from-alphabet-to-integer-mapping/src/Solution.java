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


    public static void main(String[] args) {
        Solution solution = new Solution();
        // String s = "10#11#12";
        // String s = "1326#";
        // String s = "25#";

        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        String res = solution.freqAlphabets(s);


        System.out.println(res);


    }
}
