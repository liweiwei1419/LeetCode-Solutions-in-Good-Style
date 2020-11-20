import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // [[1,0]]
    // 学习课程 1 之前，你需要完成课程 0。
    // 建图顺序 0 —> 1

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }

        // 1、构建邻接表，使用 Set 是为了去重
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 2、填写邻接表与入度表，入度：指向它的结点的个数
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        // 3、首先加入入度为 0 的结点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int count = 0;

        // 4、类似广度优先遍历的写法
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            count += 1;
            // 遍历当前出队结点的所有后继结点，将它们的入度减 1
            for (int successor : adj[head]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return count == numCourses;
    }
}