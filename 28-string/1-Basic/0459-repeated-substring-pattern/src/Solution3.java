public class Solution3 {

    public boolean repeatedSubstringPattern3(String s) {
        // 掐头去尾只要包含就可以了
        return ((s + s).substring(1, 2 * s.length() - 1).contains(s));
    }
}