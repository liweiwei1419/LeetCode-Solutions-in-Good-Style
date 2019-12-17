import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 这个版本的解答是比较好理解的，并且也通过了
 * 参考资料：http://massivealgorithms.blogspot.com/2016/03/leetcode-336-palindrome-pairs.html
 *
 */
public class Solution {

    /**
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        int len = words.length;
        HashMap<String, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int k = 0; k <= wordLen; k++) {
                String wordLeft = word.substring(0, k);
                String wordRight = word.substring(k, wordLen);
                // System.out.println(wordLeft + "-" + wordRight);
                if (isPalindrome(wordLeft)) {
                    Integer j = map.get(new StringBuilder(wordRight).reverse().toString());
                    if (j != null && j != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(j);
                        pair.add(i);
                        res.add(pair);
                    }
                }
                if (isPalindrome(wordRight)) {
                    Integer j = map.get(new StringBuilder(wordLeft).reverse().toString());
                    if (j != null && j != i && wordRight.length() != 0) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);
                        res.add(pair);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word) {
        int len = word.length();
        if (len == 0) {
            return true;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a", ""};
        Solution solution = new Solution();
        List<List<Integer>> palindromePairs = solution.palindromePairs(words);
        System.out.println(palindromePairs);
    }
}
