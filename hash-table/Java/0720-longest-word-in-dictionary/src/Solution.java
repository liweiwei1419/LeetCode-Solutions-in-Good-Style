import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
public class Solution {

    public String longestWord(String[] words) {
        int len = words.length;
        if (len == 0) {
            return "";
        }
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < len; i++) {
            dict.add(words[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 != len2) {
                    return len1 - len2;
                }
                // 注意这里的顺序
                return o2.compareTo(o1);
            }
        };
        Arrays.sort(words, comparator);
        // System.out.println(Arrays.toString(words));
        // 从后向前遍历
        for (int i = len - 1; i >= 0; i--) {
            if (judgeWordInDict(words[i], dict)) {
                return words[i];
            }
        }
        return "";
    }

    private boolean judgeWordInDict(String word, Set<String> dict) {
        int len = word.length();
        for (int i = 0; i < len - 1; i++) {
            if (!dict.contains(word.substring(0, i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Solution solution = new Solution();
        String longestWord = solution.longestWord(words);
        System.out.println(longestWord);
    }
}
