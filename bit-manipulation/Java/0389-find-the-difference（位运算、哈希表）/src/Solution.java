public class Solution {

    // 只包含小写数字，干脆全部转成 0-25 的数字就好了
    // 根据题意，t 比 s 多 1 个字符，干脆初始值就取 t 的第 1 个字符

    public char findTheDifference(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int res = t.charAt(0) - 'a';
        for (int i = 0; i < slen; i++) {
            res ^= (s.charAt(i) - 'a');
        }
        for (int i = 1; i < tlen; i++) {
            res ^= (t.charAt(i) - 'a');
        }
        return (char) (res + 'a');
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Solution solution = new Solution();
        char theDifference = solution.findTheDifference(s, t);
        System.out.println(theDifference);
    }
}