public class Solution {

    public String compressString(String S) {
        int len = S.length();
        if (len == 0) {
            return "";
        }

        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(chars[0]);

        int index = 0;
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[index]) {
                cnt++;
            } else {
                stringBuilder.append(chars[index]);
                stringBuilder.append(cnt);
                index = i;
                cnt = 1;
            }
        }

        stringBuilder.append(chars[len - 1]);
        stringBuilder.append(cnt);

        String res = stringBuilder.toString();
        if (res.length() >= len){
            return S;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "aabcccccaaa";
        String res = solution.compressString(S);
        System.out.println(res);
    }
}
