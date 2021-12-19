public class Solution2 {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }

        int minLen = 999;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        if (minLen == 0) {
            return "";
        }

        int cnt = 0;
        while (cnt < minLen) {
            char curChar = strs[0].charAt(cnt);
            for (int i = 1; i < len; i++) {
                if ( strs[i].charAt(cnt) != curChar) {
                    return strs[0].substring(0, cnt);
                }
            }
            cnt += 1;
        }
        return strs[0];
    }
}