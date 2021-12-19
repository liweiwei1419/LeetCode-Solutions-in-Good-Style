import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 第 2 步：执行双向 BFS，左右交替扩散的步数之和为所求
        Set<String> visited = new HashSet<>();

        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用（等价于使用队列）
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                // 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
                char[] charArray = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                nextLevelVisited.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArray[i] = origin;
                }
            }

            // 原来的 beginVisited 丢弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }
}