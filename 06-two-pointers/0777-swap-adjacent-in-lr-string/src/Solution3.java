public class Solution3 {

    // 官方：难理解

    public boolean canTransform(String start, String end) {
        String startNotSpace = start.replace("X", "");
        String endNotSpace = end.replace("X", "");
        if (!startNotSpace.equals(endNotSpace)) {
            return false;
        }
        char[] startCharArray = start.toCharArray();
        char[] endCharArray = end.toCharArray();
        int len = start.length();

        int i = 0;
        int j = 0;
        // 这代码也太难写了
        while (i < len) {
            if (startCharArray[i] == 'X') {
                i++;
                continue;
            }

            if (endCharArray[j] == 'X') {
                j++;
                continue;
            }

            if (startCharArray[i] == 'L' && i < j) {
                return false;
            }
            if (startCharArray[i] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}