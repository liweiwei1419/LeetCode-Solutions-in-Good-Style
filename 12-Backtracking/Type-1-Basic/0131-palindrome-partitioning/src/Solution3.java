import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int len = s.length();
        dfs(s, len, 0, "", result);
        return result;
    }

    private void dfs(String s, int len, int begin, String pre, List<List<String>> result) {
        // 调试语句
        // System.out.println(begin + " " + pre);
        // 起始点站在了字符串最后一个字符的后面
        if (begin == len) {
            result.add(str2List(pre));
        }
        String reverseStr;
        for (int i = begin + 1; i <= len; i++) {
            // 每一个可以分割的地方都尝试过去
            reverseStr = s.substring(begin, i);
            if (isPalindrome(reverseStr)) {
                dfs(s, len, i, pre + reverseStr + ".", result);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private List<String> str2List(String str) {
        List<String> result = new ArrayList<>();
        // 注意1：. 有特殊含义，需要转义
        // 注意2：. 在末尾可以忽略，在开头就要算进去
        String[] reverseArr = str.split("\\.");
        int length = reverseArr.length;
        result.addAll(Arrays.asList(reverseArr).subList(0, length));
        return result;
    }
}