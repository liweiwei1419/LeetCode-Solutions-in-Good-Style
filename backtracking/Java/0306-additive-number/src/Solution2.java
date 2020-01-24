import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 测试用

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(num, 0, len, path, res);
        // System.out.println(res);
        return false;
    }

    private void dfs(String num, int start, int len, List<Integer> path, List<List<Integer>> res) {
        // System.out.println(path);
        if (start == len && path.size() >= 3) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() == 0) {
            // 枚举当前截取的字符串的结尾
            for (int i = 0; i < len / 2; i++) {
                // 因为 substring 右边界不包含，所以传入 i 的时候得 + 1
                String curNum = num.substring(start, i + 1);
                System.out.println("curNum " + curNum);
                if (curNum.length() > 1 && curNum.startsWith("0")) {
                    return;
                }
                path.add(Integer.parseInt(curNum));

                dfs(num, i + 1, len, path, res);

                path.remove(path.size() - 1);
            }
        } else if (path.size() == 1) {

            int firstLen = (path.get(0) + "").length();

            for (int i = start; i < len; i++) {
                // 因为 substring 右边界不包含，所以传入 i 的时候得 + 1
                String curNum = num.substring(start, i + 1);
                if (curNum.length() > 1 && curNum.startsWith("0")) {
                    return;
                }
                path.add(Integer.parseInt(curNum));

                dfs(num, i + 1, len, path, res);

                path.remove(path.size() - 1);
            }
        } else {
            // 此时 path 里面至少有 2 个数了

            int preNum1 = path.get(path.size() - 2);
            int preNum2 = path.get(path.size() - 1);

            int curNum = preNum1 + preNum2;

            String curNumStr = curNum + "";
            int curNumLen = curNumStr.length();
            if (start + curNumLen > len) {
                return;
            }
            if (curNumStr.equals(num.substring(start, start + curNumLen))) {
                path.add(curNum);
                dfs(num, start + curNumLen, len, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String num = "199111992";
        // String num = "12122436";
        Solution2 solution = new Solution2();
        boolean res = solution.isAdditiveNumber(num);
        System.out.println(res);
    }
}
