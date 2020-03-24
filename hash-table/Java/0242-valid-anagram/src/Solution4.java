public class Solution4 {

    private int[] counter(char[] arr) {
        int[] counter = new int[26];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            counter[index]++;
        }
        return counter;
    }

    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] counter1 = counter(sChars);
        int[] counter2 = counter(tChars);
        for (int i = 0; i < 26; i++) {
            if (counter1[i] != counter2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int slen = s == null ? 0 : s.length();
        int tlen = t == null ? 0 : t.length();
        if (slen != tlen) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] counter1 = counter(sChars);
        int[] counter2 = counter(tChars);
        for (int i = 0; i < 26; i++) {
            if (counter1[i] != counter2[i]) {
                return false;
            }
        }
        return true;
    }
}
