public class Solution {

    public boolean canTransform(String start, String end) {
        int len = start.length();
        if (len == 0 || len != end.length()) {
            return false;
        }

        char[] startCharArray = start.toCharArray();
        char[] endCharArray = end.toCharArray();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            char c1 = startCharArray[i];
            char c2 = endCharArray[i];
            diff += (c1 - c2);
            if (diff < 0) {
                // 不可以遇到 L
                if (c1 == 'L' || c2 == 'L') {
                    return false;
                }
            } else if (diff > 0) {
                // 不可以遇到 R
                if (c1 == 'R' || c2 == 'R') {
                    return false;
                }
            }
        }
        return diff == 0;
    }
}