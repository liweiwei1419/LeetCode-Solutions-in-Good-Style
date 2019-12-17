import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/28 4:53 PM
 */
public class Solution5 {

    private boolean judgeIfIPSegment(String ipSegment) {
        // 大于 1 位的时候，不能以 0 开头
        if (ipSegment.length() > 1 && ipSegment.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(ipSegment) <= 255;
    }

    private void backtracking(int split, int begin) {
        // 先写递归终止条件
        if (split == 4 && begin == s.length()) {
            res.add(String.join(".", stack));
            return;
        }

        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (begin + i > len) {
                break;
            }
            // 可能成为 ip 段的字符串
            String segment = s.substring(begin, begin + i);
            if (judgeIfIPSegment(segment)) {
                stack.add(segment);
                backtracking(split + 1, begin + i);
                stack.pop();
            }
        }
    }

    private String s;
    private Stack<String> stack;
    private List<String> res;
    private int len;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        this.len = s.length();

        if (this.len == 0 || this.len > 12) {
            return res;
        }
        this.s = s;
        this.stack = new Stack<>();

        backtracking(0, 0);
        return res;
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
