import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    // 方法二：广度优先遍历

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        set.add(s);
        while (true) {
            for (String str : set) {
                if (isRegular(str)) {
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : set) {
                for (int i = 0; i < str.length(); i ++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1, str.length()));
                    }
                }
            }
            set = nextSet;
        }
    }

    public boolean isRegular(String s) {
        char[] ss = s.toCharArray();
        int count = 0;
        for (char c : ss) {
            if (c == '(') {
                count ++;
            } else if (c == ')') {
                count --;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}