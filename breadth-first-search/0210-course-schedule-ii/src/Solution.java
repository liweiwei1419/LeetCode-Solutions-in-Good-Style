import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 使用拓扑排序来完成
 *
 * @author liwei
 * @date 18/6/24 下午3:11
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 先处理极端情况
        if (numCourses <= 0) {
            return new int[0];
        }
        // 邻接表表示
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        // 入度表
        int[] inDegree = new int[numCourses];
        // 遍历 prerequisites 的时候，把 邻接表 和 入度表 都填上
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer inDegreeNode = queue.removeFirst();
            // 加入结果集中
            res.add(inDegreeNode);
            // 下面从图中删去
            // 得到所有的后继课程，接下来把它们的入度全部减去 1
            HashSet<Integer> nextCourses = graph[inDegreeNode];
            for (Integer nextCourse : nextCourses) {
                inDegree[nextCourse]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse);
                }
            }
        }
        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        int resLen = res.size();
        if (resLen == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }
}

