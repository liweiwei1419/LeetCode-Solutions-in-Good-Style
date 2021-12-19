import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int maxLen;

    public int maxUniqueSplit(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        Set<String> hashSet = new HashSet<>();
        dfs(charArray, 0, len, hashSet);
        return maxLen;
    }

    private void dfs(char[] charArray, int index, int len, Set<String> hashSet) {
        // 剪枝想法来自 Ikaruga：https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings/solution/split-a-string-by-ikaruga/
        if (len - index + hashSet.size() <= maxLen) {
            return;
        }

        if (index == len) {
            maxLen = Math.max(maxLen, hashSet.size());
            // System.out.println(hashSet);
            return;
        }

        for (int i = index; i < len; i++) {
            // 截取字符串
            StringBuilder subStr = new StringBuilder();
            for (int j = index; j <= i; j++) {
                subStr.append(charArray[j]);
            }
            String s = subStr.toString();
            if (hashSet.contains(s)) {
                continue;
            }
            hashSet.add(s);
            dfs(charArray, i + 1, len, hashSet);
            hashSet.remove(s);
        }
    }
}