import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution2 {

    private List<List<Integer>> pos;

    public int numMatchingSubseq(String S, String[] words) {
        // 起到 hash 表的作用
        pos = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            pos.add(new ArrayList<>());
        }
        char[] s = S.toCharArray();
        int slen = S.length();
        for (int i = 0; i < slen; i++) {
            // key 是字符
            // value 是这个字符在 S 串中的索引
            // 其中的列表一定是递增序列，索引后面再进行匹配的时候，可以使用二分搜索法
            pos.get(s[i]).add(i);
        }
        // 下面单词逐个找
        int ans = 0;
        for (String word : words) {
            // 把每个单词都放到 hash 表中做一次匹配
            if (match(word)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean match(String word) {
        int l = -1;
        for (char c : word.toCharArray()) {
            List<Integer> p = pos.get(c);
            int index = Collections.binarySearch(p, l + 1);
            // 这一点和 Collections.binarySearch 有关
            // 没有找到，就返回 (-(插入点) - 1)
            if (index < 0) {
                index = -index - 1;
            }
            // 有不在 hash 表中的字符，索引返回 false
            if (index >= p.size()) {
                return false;
            }
            l = p.get(index);
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        Solution2 solution2 = new Solution2();
        int numMatchingSubseq = solution2.numMatchingSubseq(S, words);
        System.out.println(numMatchingSubseq);
    }
}
