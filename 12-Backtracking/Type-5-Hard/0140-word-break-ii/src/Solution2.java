import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>(wordDict);

        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, hashSet, path, res);
        return res;
    }

    private void dfs(String s, int index, Set<String> hashSet, Deque<String> path, List<String> res) {
        if (index == s.length()) {
            res.add(getString(path));
            return;
        }

        for (int k = index; k < s.length(); k++) {
            String substring = s.substring(index, k + 1);
            if (hashSet.contains(substring)) {
                // System.out.println(path);
                path.addLast(substring);
                dfs(s, k + 1, hashSet, path, res);
                path.removeLast();
                // System.out.println(path);
            }
        }
    }

    private String getString(Deque<String> path) {
        return String.join(" ", path);
    }
}