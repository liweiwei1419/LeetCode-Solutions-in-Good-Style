import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution4 {

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();

        Map<String, ArrayList<String>> allComboDict = new HashMap<>();

        for (String s : wordList) {
            for (int i = 0; i < len; i++) {
                // 得到这个单词所有的模式
                String newWord = s.substring(0, i) + '*' + s.substring(i + 1, len);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(s);

                allComboDict.put(newWord, transformations);
            }
        }

        // 预处理
        Set<Map.Entry<String, ArrayList<String>>> entries = allComboDict.entrySet();
        for (Map.Entry<String, ArrayList<String>> map:entries) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();

            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i++) {
                // 拿出这个单词所有的模式
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);

                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, words);

        Solution4 solution4 = new Solution4();
        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution4.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));
    }
}
