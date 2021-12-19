public class Solution {

    // 贪心算法

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];

        char[] charArray = seq.toCharArray();
        for (int i = 1; i < len; i++) {
            if (charArray[i] == charArray[i - 1]) {
                res[i] = 1 - res[i - 1];
            } else {
                res[i] = res[i - 1];
            }
        }
        return res;
    }
}