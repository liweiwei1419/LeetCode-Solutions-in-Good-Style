import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution4 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len <= 0) {
            return res;
        }

        int splitTimes = 0;

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, splitTimes, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int splitTimes, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (splitTimes == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }


            if (judgeStringIfIpNum(s, begin, begin + i)) {
                String currentNum = s.substring(begin, begin + i + 1);

                path.addLast(currentNum);
                dfs(s, len, begin + i + 1, splitTimes + 1, path, res);
                path.removeLast();
            }
        }
    }


    private boolean judgeStringIfIpNum(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}
