import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution3 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：开始广度优先遍历
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 依次遍历当前队列中的单词
                String front = queue.poll();

                int wordLen = front.length();
                char[] charArray = front.toCharArray();
                // 尝试修改每一位上的字母
                for (int j = 0; j < wordLen; j++) {
                    // 注意：每次只能修改一个字符，因此需要暂存当前位的字符
                    char origin = charArray[j];
                    // 一共修改 26 次，修改成 origin 是没有必要的，但不做特殊处理
                    for (char k = 'a'; k <= 'z'; k++) {
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                // 注意：添加到队列以后，必须马上标记为已经访问
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(words));

        int res = solution3.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}