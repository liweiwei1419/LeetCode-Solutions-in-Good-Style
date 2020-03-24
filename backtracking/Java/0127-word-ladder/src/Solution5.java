import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5 {

    // 双向 BFS

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 List 转换为 Set 以去除重复
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)){
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int step = 1;

        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

//            System.out.println("beginSet " + beginSet);
//            System.out.println("endSet " + endSet);

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }


            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {

                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;

                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return step + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        // String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        Collections.addAll(wordList, words);

        Solution5 solution5 = new Solution5();
        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution5.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));
    }
}
