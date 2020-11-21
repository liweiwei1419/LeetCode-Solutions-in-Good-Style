public class Solution {

    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return 0;
        }

        int[] map = new int[26];
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                return i;
            }
        }
        return -1;
    }
}