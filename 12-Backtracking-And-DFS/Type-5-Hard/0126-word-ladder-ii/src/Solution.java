import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // 由于需要快速判断扩展出的单词是否在 wordList 里，
        // 因此需要将 wordList 存入哈希表，这里命名为「字典」
        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例判断
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);


        // 第 1 步：使用广度优先遍历得到后继结点列表 from
        // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
        // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
        Map<String, Set<String>> from = new HashMap<>();

        boolean found = bfs(beginWord, endWord, dict, from, steps);
        if (!found) {
            return res;
        }

        // 第 2 步：基于后继结点列表 from ，使用回溯算法得到所有最短路径列表
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, from, path, res);
        return res;
    }

    private boolean bfs(String beginWord, String endWord,
                        Set<String> dict, Map<String, Set<String>> from, Map<String, Integer> steps) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        boolean found = false;
        int wordLen = beginWord.length();
        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (!dict.contains(nextWord)) {
                            continue;
                        }

                        if (nextWord.equals(endWord)) {
                            found = true;
                        }

                        // steps 记录了已经访问过的 word 集合，同时记录了在第几层访问到
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currentWord);
                        }

                        from.computeIfAbsent(currentWord, a -> new HashSet<>());
                        from.get(currentWord).add(nextWord);
                    }
                    charArray[j] = originChar;
                }
            }

            if (found) {
                break;
            }
        }
        return found;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> from, Deque<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (!from.containsKey(beginWord)) {
            return;
        }

        Set<String> successorWords = from.get(beginWord);
        for (String nextWord : successorWords) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, from, path, res);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] wordArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
//        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
//
//        Solution solution = new Solution();
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);

        String beginWord = "a";
        String endWord = "c";
        String[] wordArray = new String[]{"a", "b", "c"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
        Solution solution = new Solution();
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }
}
