public class Solution2 {

    // 方法二：递归

    /**
     * 思想：递归，减而治之
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     *
     * @param s 文本串，有时候也用 t 表示
     * @param p 模式串
     * @return
     */
    public boolean isMatch(String s, String p) {
        // 先写递归终止条件
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        // 满足 firstMatch 就表示可以同时砍掉模式串 p 和文本串 s 的第 1 个字符
        // ① 第 1 个字符正正好相等
        // ② 模式串的第 1 个字符正正好是 '.'，因为可以匹配任意单个字符
        boolean firstMatch = !s.isEmpty() && (sCharArray[0] == pCharArray[0] || pCharArray[0] == '.');

        // 当模式串的下一个是 *
        // ① * 号的作用是 0 次：模式串与前面的都不匹配，例如：s = 'bb'，p = 'a*bb'，模式串直接砍掉 2 个（连同 * 一起砍掉），继续匹配
        // ② * 号的作用是 1 次或者更多次：在满足 firstMatch 的前提下，s 砍掉 1 个然后继续
        if (p.length() > 1 && pCharArray[1] == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            return firstMatch && isMatch(s.substring(1), p);
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}