public class Solution2 {

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        char[] charArray = seq.toCharArray();
        int depth = 0;
        int curLeft = 0;
        for (char c : charArray) {
            if (c == '(') {
                curLeft++;
                depth = Math.max(depth, curLeft);
            } else {
                curLeft--;
            }
        }

        int ASize = depth / 2;

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                curLeft++;
                if (curLeft > ASize) {
                    res[i] = 1;
                }
            } else {
                if (curLeft > ASize) {
                    res[i] = 1;
                }
                curLeft--;
            }
        }
        return res;
    }
}