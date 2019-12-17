import java.util.ArrayList;
import java.util.List;

/**
 * 参考资料：https://leetcode.com/problems/number-of-matching-subsequences/discuss/141028/Java-Solution-Using-HashMap-and-Binary-Search-and-sharing-my-thoughts!!!666
 * @author liwei
 */
public class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int slen = S.length();
        int wlen = words.length;
        if (slen == 0 || wlen == 0) {
            return 0;
        }
        List<Integer>[] dict = new ArrayList[26];
        for (int i = 0; i < slen; i++) {
            char c = S.charAt(i);
            int index = c - 'a';
            if (dict[index] == null) {
                dict[index] = new ArrayList<>();
            }
            dict[index].add(i);
        }

        int count = 0;
        for (String word : words) {
            if (match(word, dict)) {
                count++;
            }
        }
        return count;
    }

    private boolean match(String word, List<Integer>[] dict) {
        int start = -1;
        char[] chars = word.toCharArray();
        // 每一个字母都要看过去
        for (char c : chars) {
            int index = c - 'a';
            List<Integer> indexes = dict[index];
            if (indexes == null) {
                return false;
            }
            int l = 0;
            int r = indexes.size() - 1;
            if (indexes.get(r) <= start) {
                return false;
            }
            // 二分查找法要这么找：我们要找的是比当前索引要大 1 的元素，
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (indexes.get(mid) > start) {
                    r = mid;
                } else {
                    assert indexes.get(mid) <= start;
                    l = mid + 1;
                }
            }
            // 跳出上面 while 循环的时候，一定是 l 和 r 挤在一起了，所以返回 r
            assert l == r;
            if (indexes.get(r) <= start) {
                return false;
            }
            start = indexes.get(r);
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        Solution solution = new Solution();
        int numMatchingSubseq = solution.numMatchingSubseq(S, words);
        System.out.println(numMatchingSubseq);
    }
}
