import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution3 {

    // 推荐的，固定模式的写法

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList 中如果有 beginWord 应该删除，用哈希表便于查找和修改
        Set<String> hashSet = new HashSet<>(wordList);
        hashSet.remove(beginWord);

        // BFS 必须使用队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String word = queue.poll();

                int len = word.length();
                char[] charArray = word.toCharArray();

                // 修改每一个字符
                for (int j = 0; j < len; j++) {
                    // 一轮以后应该重置，否则结果不正确
                    char currentChar = charArray[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        charArray[j] = k;
                        String temp = String.valueOf(charArray);

                        if (hashSet.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return step + 1;
                            }
                            queue.add(temp);

                            // 找到了以后，下一次就不是目标了，所以要删除
                            hashSet.remove(temp);
                        }
                    }

                    // 恢复，下次再用
                    charArray[j] = currentChar;
                }
            }
            step++;
        }
        return 0;
    }
}
