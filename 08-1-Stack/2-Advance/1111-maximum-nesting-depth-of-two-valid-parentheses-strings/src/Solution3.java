public class Solution3 {

    // 栈

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        char[] charArray = seq.toCharArray();
        int[] res = new int[len];

        int left = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                left++;
                res[i] = left % 2;
            } else {
                res[i] = left % 2;
                left--;
            }
        }
        return res;
    }
}