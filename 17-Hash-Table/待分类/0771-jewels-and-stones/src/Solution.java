public class Solution {

    public int numJewelsInStones(String J, String S) {
        boolean[] hashMap = new boolean[256];
        for (char c : J.toCharArray()) {
            hashMap[c] = true;
        }

        int cnt = 0;
        for (char s : S.toCharArray()) {
            if (hashMap[s]) {
                cnt++;
            }
        }
        return cnt;
    }
}
