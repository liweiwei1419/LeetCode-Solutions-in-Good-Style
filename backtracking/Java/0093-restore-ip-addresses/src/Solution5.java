import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution5 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 剪枝
        if (len == 0 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(len);
        dfs(s, len, 0, 0, path, res);
        return res;
    }

    private boolean judgeIfIpSegment(String ipSegment) {
        // 大于 1 位的时候，不能以 0 开头
        if (ipSegment.length() > 1 && ipSegment.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(ipSegment) <= 255;
    }

    private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (split == 4 && begin == s.length()) {
            res.add(String.join(".", path));
            return;
        }

        // 看到剩下的不够了，就退出（剪枝）
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            // 剪枝
            if (begin + i > len) {
                break;
            }
            // 可能成为 ip 段的字符串，不包括 begin + i 这个数值
            String segment = s.substring(begin, begin + i);
            if (judgeIfIpSegment(segment)) {
                path.addLast(segment);
                dfs(s, len, split + 1, begin + i, path, res);
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        String num = "25525511135";
        Solution5 solution5 = new Solution5();
        List<String> restoreIpAddresses = solution5.restoreIpAddresses(num);
        for (String s : restoreIpAddresses) {
            System.out.println(s);
        }
    }
}
