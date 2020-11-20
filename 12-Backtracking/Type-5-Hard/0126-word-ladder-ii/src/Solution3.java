import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution3 {

    // 官方题解

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();

        // 如果字典为空或者字典中单词为空返回空列表
        if (wordList.size() == 0 || wordList.get(0).length() == 0) {

            return res;
        }

        // 哈希表保存候选结点
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        // 如果字典中不存在 endword 则返回空列表
        if (!wordSet.contains(endWord)) {
            return res;
        }

        // 队列保存访问的路径
        Queue<List<String>> queue = new LinkedList<>();
        List<String> head = new ArrayList<>();

        // 将 beginWord 存入队列中，作为路径的起点
        head.add(beginWord);
        queue.offer(head);
        // 终点出现标志，当路径中出现终点时，说明找到最短路径，不再进行下一层的循环
        boolean flag = true;

        while (flag && (!queue.isEmpty())) { //当出现终点或者搜索完所有结点则结束循环
            int qSize = queue.size(); //当前队列长度表示每层的可达结点个数
            Set<String> accessible = new HashSet<>(); // 哈希表保存该层的可达结点
            for (int i = 1; i <= qSize; i++) {
                List<String> tmp = queue.poll(); // 从队列中取出一条路径

                for (String str : wordSet) { //遍历候选结点中是否存在可达结点
                    if (compareWord(tmp.get(tmp.size() - 1), str)) { //候选结点与路径的最后一个结点作比较，判断该候选结点是否可达
                        accessible.add(str); //将可达结点存入可达结点集合
                        List<String> path = new ArrayList<>(tmp);
                        path.add(str); //将可达结点存入路径尾部
                        queue.offer(path); //将新路径存入队列中
                        if (endWord.equals(str)) {
                            flag = false; //如果终点出现在可达结点中，说明找到最短路径，该层结点搜索完成后不再进行下一层
                        }
                    }
                }
            }
            wordSet.removeAll(accessible); // 当搜索完一层的结点时，将该层的可达结点全部从候选结点中删除，形成新的候选结点
            // System.out.println(" " + queue);
        }


        while (!queue.isEmpty()) { //如果路径队列非空，则将路径终点等于endWord的路径挑出来存入列表中，否则说明不存在最短路径
            List<String> tmp = queue.poll();
            if (tmp.get(tmp.size() - 1).equals(endWord)) {
                res.add(tmp);
            }
        }
        return res;
    }

    private boolean compareWord(String word1, String word2) { //判断可达结点，两字符串是否只有一个字符不同
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int count = 0;
        for (int i = 0; i < word1Array.length; i++) {
            if (word1Array[i] != word2Array[i]) {
                count++;
            }
        }
        return count < 2;
    }
}