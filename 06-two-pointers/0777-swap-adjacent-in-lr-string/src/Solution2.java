public class Solution2 {

    // 官方：暴力解法

    public boolean canTransform(String start, String end) {
        String startNotSpace = start.replace("X", "");
        String endNotSpace = end.replace("X", "");
        if (!startNotSpace.equals(endNotSpace)) {
            return false;
        }
        char[] startCharArray = start.toCharArray();
        char[] endCharArray = end.toCharArray();
        int len = start.length();

        int left = 0;
        for (int i = 0; i < len; i++) {
            if (startCharArray[i] == 'L') {
                while (endCharArray[left] != 'L') {
                    left++;
                }
                if (i < left) {
                    return false;
                }
                left++;
            }
        }
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (startCharArray[i] == 'R') {
                while (endCharArray[right] != 'R') {
                    right++;
                }
                if (i > right) {
                    return false;
                }
                right++;
            }
        }
        return true;
    }
}