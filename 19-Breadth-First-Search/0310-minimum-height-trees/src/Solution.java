import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 特判
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        
        // 入度数组，每一次要把入度为 1 的结点剔除
        int[] inDegrees = new int[n];
        // 默认为 False，如果剔除，设置为 True
        boolean[] result = new boolean[n];
        // 因为是无向图，所以邻接表拿出一条边，两个结点都要存一下
        // 注意：右边就不要写具体的实现类了，等到实例化的时候再写具体的实现类
        Set<Integer>[] adjs = new Set[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjs[start].add(end);
            adjs[end].add(start);
            inDegrees[start] += 1;
            inDegrees[end] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 入度为 1 的结点入队
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                queue.offer(i);
            }
        }
        // 注意边界条件 n == 2 和 n == 1 是如何分析出来的
        while (n > 2) {
            int size = queue.size();
            System.out.println(queue);
            // 一次减去这么多
            n -= size;
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                result[top] = true;
                inDegrees[top] -= 1;
                // 把它和它的邻接结点的入度全部减 1
                Set<Integer> successors = adjs[top];
                for (Integer successor : successors) {
                    inDegrees[successor] -= 1;
                    if (inDegrees[successor] == 1) {
                        queue.offer(successor);
                    }
                }
            }
        }

        n = result.length;
        for (int i = 0; i < n; i++) {
            if (!result[i]) {
                res.add(i);
            }
        }
        return res;
    }
}