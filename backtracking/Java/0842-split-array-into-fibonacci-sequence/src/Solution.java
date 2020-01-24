import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        backtrackiong(S, 0, len, res);
        return res;

    }

    private boolean backtrackiong(String S, int start, int len, List<Integer> res) {
        if (start == len) {
            return res.size() > 2;
        }

        int num = 0;
        for (int i = start; i < len; i++) {
            num = num * 10 + (S.charAt(i) - '0');
            if (num < 0) {
                return false;
            }
            if (res.size() < 2 || res.get(res.size() - 2) + res.get(res.size() - 1) == num) {
                res.add(num);
                if (backtrackiong(S, i + 1, len, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
            if (i == start && S.charAt(i) == '0') {
                return false;
            }
        }
        return false;
    }
}
