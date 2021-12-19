public class Solution3 {

    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        Character[] map = new Character[256];
        boolean[] set = new boolean[256];
        for (int i = 0; i < slen; i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map[key] == null) {
                // 建立映射关系
                if (set[value]) {
                    return false;
                }
                map[key] = value;
                set[value] = true;
            } else {
                if (map[key] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}