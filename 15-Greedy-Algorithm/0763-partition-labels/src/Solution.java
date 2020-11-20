import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 题目关键字：返回一个表示每个字符串片段的长度的列表
    // 思路（来自官方题解）：由于同一个字母只能出现在同一个片段，
    // 显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。

    public List<Integer> partitionLabels(String S) {
        char[] charArray = S.toCharArray();
        int[] last = new int[26];

        int len = S.length();
        // 记录 S 中出现的字符最后一次出现的下标
        for (int i = 0; i < len; i++) {
            last[charArray[i] - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int k = 0;
        // 由于保存的是长度，这里初始化为 -1
        int cut = -1;
        for (int i = 0; i < len; i++) {
            k = Math.max(k, last[charArray[i] - 'a']);

            // 贪心选择
            if (i == k) {
                res.add(i - cut);
                cut = i;
            }
        }
        return res;
    }
}