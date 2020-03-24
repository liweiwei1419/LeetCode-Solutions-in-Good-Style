/**
 * 任何字符串本身都是一个子序列，空字符串是任何字符串的子序列。
 * 只需要判断两字符串是否相等，如果相等就返回 -1 ，不相等就返回较长的字符串长度。算是有一些坑的问题了，这道问题踩的人比较多。
 *
 * @author liwei
 */
public class Solution {

    public int findLUSlength(String a, String b) {
        if (a != null && a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
