import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution4 {

    private List<String> arrConvertList(String str) {
        List<String> res = new ArrayList<>();
        Collections.addAll(res, str.split(","));
        return res;
    }

    private void findReverse(String s, int begin, String pre, List<List<String>> res) {
        if (begin == s.length()) {
            res.add(arrConvertList(pre));
            return;
        }
        for (int i = begin + 1; i <= s.length(); i++) {
            String ifReserve = s.substring(begin, i);
            if (isPalindrome(ifReserve)) {
                findReverse(s, i, pre + ifReserve + ",", res);
            }
        }
    }

    /**
     * 判断是否回文
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        // 01210 5 2
        // 012210 6 3
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return res;
        }
        findReverse(s, 0, "", res);
        return res;
    }
}