import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 步骤 1：构建邻接表
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        int pLen = prerequisites.length;
        for (int i = 0; i < pLen; i++) {
            // 后继课程
            int second = prerequisites[i][0];
            // 先行课程
            int first = prerequisites[i][1];
            adj[first].add(second);
        }

        // 步骤二：对每一个结点执行一次深度优先遍历
        // 0 表示没有访问过，对应于 boolean 数组里的 false
        // 1 表示已经访问过，新增状态，如果 dfs 的时候遇到 1 ，表示当前遍历的过程中形成了环
        // 2 表示当前结点的所有后继结点已经遍历完成，对应于 boolean 数组里的 true
        int[] visited = new int[numCourses];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            // 对每一个结点执行一次深度优先遍历
            if (dfs(i, adj, visited, res)) {
                // 如果有环，返回空数组
                return new int[]{};
            }
        }

        // 注意：这里需要逆向
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * @param current
     * @param adj
     * @param visited
     * @param res
     * @return true 表示有环，false 表示没有环
     */
    private boolean dfs(int current, Set<Integer>[] adj,
                        int[] visited, List<Integer> res) {
        if (visited[current] == 1) {
            return true;
        }
        if (visited[current] == 2) {
            return false;
        }

        visited[current] = 1;
        for (Integer successor : adj[current]) {
            if (dfs(successor, adj, visited, res)) {
                return true;
            }
        }

        // 注意：在「后序」这个位置添加到结果集
        res.add(current);
        visited[current] = 2;
        // 所有的后继结点都遍历完成以后，都没有遇到重复，才可以说没有环
        return false;
    }
}