public class Solution3 {

    // 感觉自己写得太啰嗦了

    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0) {
            return true;
        }
        if (slen > tlen) {
            return false;
        }
        int si = 0;
        int ti = 0;
        // s 和 t 相同的数量
        int sameNum = 0;
        while (si < slen && ti < tlen) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
                sameNum++;
                // 如果 s 已经全部遍历过
                if (si == slen) {
                    // 返回 s 和 t 相同的数量是不是与 s 的字符数相同
                    return sameNum == slen;
                }
            } else {
                ti++;
            }
        }
        return false;
    }
}