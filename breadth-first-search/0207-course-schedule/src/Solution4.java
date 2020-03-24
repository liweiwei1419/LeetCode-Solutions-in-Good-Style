import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 该方法还存储了拓扑排序的结果，个人觉得这种写法很好理解，根据这个写法可以马上写出 LeetCode 第 210 题 课程表 II
 * 参考资料：https://www.cnblogs.com/yrbbest/p/4493547.html
 *
 * @author liwei
 * @date 18/6/24 下午12:20
 */
public class Solution4 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }


    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 6},
                {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        int numCourses = 8;
        Solution4 solution4 = new Solution4();
        boolean canFinish = solution4.canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }
}
