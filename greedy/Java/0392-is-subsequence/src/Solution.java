/**
 * @author liweiwei1419
 * @date 2019/11/23 2:02 上午
 */
public class Solution {

    // https://leetcode-cn.com/problems/is-subsequence/

    // 贪心算法

    // 大数据如何处理

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;

    }
}
