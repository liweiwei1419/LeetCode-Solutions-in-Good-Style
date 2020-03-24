import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution3 {

    // 在执行完 LeetCode 所有的测试用例中，解法 2 用时：93 ms，解法 3 用时： 105 ms。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        // 添加到末尾
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            // 从队列首出队
            String word = queue.poll();
            int curStep = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                // 相当于每次只更改一个位置的字母
                // 然后再丢到 set 中检查，这样效率很高
                // 充分利用了查找表的优良查找性质
                char[] wordUnits = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnits[i] = j;
                    String temp = new String(wordUnits);
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

    public static void main(String[] args) {
        // 测试用例
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        for (String word : words) {
            wordList.add(word);
        }
        Solution3 solution = new Solution3();

        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));

    }
}
