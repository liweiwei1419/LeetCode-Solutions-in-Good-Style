public class Solution2 {

    // 参考解答：https://leetcode-cn.com/problems/buddy-strings/solution/
    // if else 比较多

    public boolean buddyStrings(String A, String B) {
        int alen = A.length();
        int blen = B.length();

        if (alen != blen) {
            return false;
        }

        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < alen; ++i) {
                count[A.charAt(i) - 'a']++;
                if (count[A.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        // 当 A 和 B 不相等的时候
        int first = -1;
        int second = -1;
        for (int i = 0; i < alen; ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // 如果 first 和 second 都有值了
                    // 还发现有不一样的，就说明亲密数关系不成立
                    return false;
                }
            }
        }
        return second != -1 &&
                A.charAt(first) == B.charAt(second) &&
                A.charAt(second) == B.charAt(first);
    }
}