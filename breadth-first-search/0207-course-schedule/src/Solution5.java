import java.util.Stack;

/**
 * 使用深度优先遍历的方式完成图中是否有环的检测
 * 实在是不太好理解，我把它改成了 Solution6
 * 这个写法中的 stack 根本没有用，只是为了记录
 *
 * 参考资料：
 * https://www.cnblogs.com/yrbbest/p/4493547.html
 *
 * @author liwei
 * @date 18/6/24 下午12:42
 */
public class Solution5 {

    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int plen = prerequisites.length;
        if (plen == 0) {
            return true;
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onVisiting = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prerequisites, visited, onVisiting, stack)) {
                return false;
            }
        }
        // 在遍历的过程中，一直 dfs 都没有遇到已经重复访问的结点，就表示有向图中没有环
        return true;
    }

    /**
     *
     * @param i 当前访问的课程结点
     * @param prerequisites
     * @param visited
     * @param onVisiting
     * @param stack
     * @return
     */
    private boolean dfs(int i, int[][] prerequisites,
                        boolean[] visited, boolean[] onVisiting,
                        Stack<Integer> stack) {
        // 如果访问过了，就不用再访问了
        if (visited[i]) {
            return true;
        }

        visited[i] = true;
        onVisiting[i] = true;
        for (int[] p : prerequisites) {
            // p[0] 是后继课程
            if (p[0] == i) {
                // 如果前驱课程正在访问，则表示构成环
                if (onVisiting[p[1]]) {
                    return false;
                }
                // 如果前驱课程还没有访问过，继续 dfs
                if (!visited[p[1]]) {
                    if (!dfs(p[1], prerequisites, visited, onVisiting, stack)) {
                        return false;
                    }
                }
            }
        }
        onVisiting[i] = false;
        stack.push(i);
        return true;
    }
}
