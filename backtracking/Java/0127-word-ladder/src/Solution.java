import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    private List<String> wordList;

    /**
     * 广度优先遍历要记录结点被遍历的情况，所以要使用一个 Set
     */
    private Set<String> visited = new HashSet<>();

    private class Pair {
        private String word;
        private Integer step;

        public Pair(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        // 遇到最短路径问题，想都不要想，先来一个队列，写成栈就全部错误了
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            String curWord = curPair.word;
            Integer step = curPair.step;
            step++;
            List<String> nextWords = onlyChangeOne(curWord);
            for (String nextWord : nextWords) {
                if (nextWord.equals(endWord)) {
                    return step;
                }
                queue.offer(new Pair(nextWord, step));
                // 千万不要忘了
                visited.add(nextWord);
            }
        }
        return 0;
    }

    /**
     * 与 word 相差一个字母的 wordList 的元素有哪些，并且要保证没有使用过
     *
     * @param word
     * @return
     */
    private List<String> onlyChangeOne(String word) {
        List<String> res = new ArrayList<>();
        int len = word.length();
        for (String match : wordList) {
            // assert match.length() == len;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != match.charAt(i)) {
                    count++;
                    // 如果不同的字母的数量已经大于 1 个，那么它就肯定不是我们要找的单词
                    if (count >= 2) {
                        break;
                    }
                }
            }
            if (count == 1 && !visited.contains(match)) {
                res.add(match);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, words);
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));
    }
}
