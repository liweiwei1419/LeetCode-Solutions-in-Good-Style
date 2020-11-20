public class Solution4 {

    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int sl = 0;
        int tl = 0;
        while (sl < slen && tl < tlen) {
            while (tl < tlen && s.charAt(sl) != t.charAt(tl)) {
                tl++;
            }
            if (tl == tlen) {
                break;
            }
            sl++;
            tl++;
        }
        return sl == slen;
    }
}