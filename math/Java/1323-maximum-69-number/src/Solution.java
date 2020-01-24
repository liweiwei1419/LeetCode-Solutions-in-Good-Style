import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximum69Number(int num) {
        int res = num;
        StringBuilder numStr = new StringBuilder(num + "");
        // System.out.println(numStr);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '6') {
                StringBuilder replace = new StringBuilder(numStr).replace(i, i + 1, "9");
                // System.out.println("-" + numStr + "-" + replace);
                res = Math.max(res, Integer.parseInt(replace.toString()));
                // continue;
            }

            if (numStr.charAt(i) == '9') {
                StringBuilder replace = new StringBuilder(numStr).replace(i, i + 1, "6");
                // System.out.println("-" + numStr + "-" + replace);
                res = Math.max(res, Integer.parseInt(replace.toString()));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 9999;
        Solution solution = new Solution();
        int res = solution.maximum69Number(num);
        System.out.println(res);
    }
}
