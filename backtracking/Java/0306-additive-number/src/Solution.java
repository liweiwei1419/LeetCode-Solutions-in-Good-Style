import java.util.Stack;

public class Solution {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        Stack<Long> path = new Stack<>();
        return backtracking(num, 0, len, path);
    }

    private boolean backtracking(String num, int start, int len, Stack<Long> path) {
        int size = path.size();
        if (start == len && size >= 3) {
            return true;
        }

        if (size == 0) {
            // 枚举当前截取的字符串的结尾
            for (int i = start; i < len / 2; i++) {
                // 因为 substring 右边界不包含，所以传入 i 的时候得 + 1
                String curNum = num.substring(start, i + 1);
                if (curNum.length() > 1 && curNum.startsWith("0")) {
                    return false;
                }

                path.add(Long.parseLong(curNum));
                if (backtracking(num, i + 1, len, path)) {
                    return true;
                }
                path.pop();
            }
        } else if (size == 1) {

            for (int i = start; i < len; i++) {
                // 因为 substring 右边界不包含，所以传入 i 的时候得 + 1
                String curNum = num.substring(start, i + 1);
                if (curNum.length() > 1 && curNum.startsWith("0")) {
                    return false;
                }

                path.add(Long.parseLong(curNum));
                if (backtracking(num, i + 1, len, path)) {
                    return true;
                }
                path.pop();
            }
        } else {
            // 此时 path 里面至少有 2 个数了
            Long preNum1 = path.get(size - 2);
            Long preNum2 = path.get(size - 1);
            Long curNum = preNum1 + preNum2;

            String curNumStr = curNum + "";
            int curNumLen = curNumStr.length();

            if (start + curNumLen <= len && curNumStr.equals(num.substring(start, start + curNumLen))) {
                path.add(curNum);
                if (backtracking(num, start + curNumLen, len, path)) {
                    return true;
                }
                path.pop();

            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String num = "199111992";
        String num = "19910011992";
        Solution solution = new Solution();
        boolean res = solution.isAdditiveNumber(num);
        System.out.println(res);
    }
}
