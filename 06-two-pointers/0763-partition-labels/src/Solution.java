import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 题目关键字：返回一个表示每个字符串片段的长度的列表
    // 思路（来自官方题解）：由于同一个字母只能出现在同一个片段，
    // 显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。

    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        char[] charArray = S.toCharArray();

        int[] lastIndex = new int[26];
        // 记录 S 中出现的字符最后一次出现的下标
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        // 当前区间里的字符出现得最远的下标
        int end = 0;
        // 循环不变量：nums[left..right] 包含的字符在其它区间里不出现，且最长
        while (right < len) {
            end = Math.max(end, lastIndex[charArray[right] - 'a']);
            if (right == end) {
                res.add(right - left + 1);
                left = right + 1;
            }
            right++;
        }
        return res;
    }
}