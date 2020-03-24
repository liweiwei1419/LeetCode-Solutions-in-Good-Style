
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/description/
 * 参考资料：花花酱
 * http://zxi.mytechroad.com/blog/graph/leetcode-210-course-schedule-ii/
 * 说明：使用深度优先遍历和拓扑排序都可以完成这道题
 * 个人觉得拓扑排序更加直观一些
 * 我把这道题的解法改成 Solution3 更符合邻接表的习惯
 *
 * @author liwei
 */
public class Solution2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化这个有向图，以邻接表的方式存储
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int plen = prerequisites.length;
        for (int i = 0; i < plen; i++) {
            // 后继课程
            int second = prerequisites[i][0];
            // 先行课程
            int first = prerequisites[i][1];
            // 注意 dfs 中，后继课程作为 key，前驱课程作为 value
            // 这种方式不符合邻接表的习惯
            // 邻接表总是通过前驱得到后继
            graph.get(second).add(first);
        }
        // System.out.println(graph);
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            // 每一次都做 dfs
            if (dfs(i, graph, visited, res)) {
                return new int[]{};
            }
        }
        // return res.stream().mapToInt(i -> i).toArray();
        int[] ret = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    /**
     * @param current
     * @param graph
     * @param visited
     * @param res
     * @return true 表示有环，false 表示没有环
     */
    private boolean dfs(int current, ArrayList<ArrayList<Integer>> graph,
                        int[] visited, List<Integer> res) {
        // 表示访问过了
        if (visited[current] == 1) {
            // 从当前正在访问结点的状态又回到了当前正在访问，说明图中有环
            return true;
        }
        if (visited[current] == 2) {
            // 表示已经处理完毕，返回 false，表示没有必要再访问了
            return false;
        }
        // 设置为 1 表示正在访问
        visited[current] = 1;
        // 它的先行课程的集合
        ArrayList<Integer> nexts = graph.get(current);
        // 把当前结点的邻居结点的每一个结点都做一次 dfs
        for (Integer next : nexts) {
            // 递归访问它的先行课程，如果先行课程回溯访问的时候，回到自己，就表示存在环，返回 true
            // 层层返回回去，就说明有环存在，这项任务完成不了
            if (dfs(next, graph, visited, res)) {
                return true;
            }
        }
        // 做完邻居结点的 dfs，自己的状态就变成 2 了
        // 一直回溯到没有前驱课程的结点，把它加入结果集
        visited[current] = 2;
        res.add(current);
        // false 表示没有环
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] solutionOrder = solution2.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(solutionOrder));
    }
}
