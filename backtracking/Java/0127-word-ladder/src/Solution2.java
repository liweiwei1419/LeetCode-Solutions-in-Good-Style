import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

    // 这种写法 map 很累赘，不推荐

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList 中如果有 beginWord 应该删除
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        // BFS 必须使用队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            // 从队列首出队
            String word = queue.poll();
            int curStep = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String temp = new String(charArray);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return curStep + 1;
                        }
                        map.put(temp, curStep + 1);
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}