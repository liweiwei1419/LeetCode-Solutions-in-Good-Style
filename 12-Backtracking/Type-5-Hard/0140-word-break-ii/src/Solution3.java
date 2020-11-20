import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution3 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>();
        for (String word : wordDict) {
            hashSet.add(word);
        }
        return wordBreak(s, hashSet, 0);
    }
    public List<String> wordBreak(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }
}