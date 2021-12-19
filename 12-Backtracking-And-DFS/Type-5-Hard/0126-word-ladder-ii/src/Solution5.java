import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 我最早写的代码
 */
public class Solution5 {

    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }

        // 第 1 步：使用广度优先遍历得到后继结点列表 successors
        // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }

        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> wordSet,
                        Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // 标准写法，记录方法问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        int wordLen = beginWord.length();
        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (charArray[j] == k) {
                            continue;
                        }
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    found = true;
                                }

                                // 避免下层元素重复加入队列，这里感谢 https://leetcode-cn.com/u/zhao-da-ming/ 优化了这个逻辑
                                if (!nextLevelVisited.contains(nextWord)) {
                                    queue.offer(nextWord);
                                    nextLevelVisited.add(nextWord);
                                }

                                // 维护 successors 的定义
                                successors.computeIfAbsent(currentWord, a -> new HashSet<>());
                                successors.get(currentWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }

            if (found) {
                break;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }

    private void dfs(String beginWord, String endWord,
                     Map<String, Set<String>> successors,
                     Deque<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (!successors.containsKey(beginWord)) {
            return;
        }

        Set<String> successorWords = successors.get(beginWord);
        for (String nextWord : successorWords) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, successors, path, res);
            path.removeLast();
        }
    }
}