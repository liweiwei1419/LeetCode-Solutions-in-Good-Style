import java.util.HashSet;

/**
 * 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 学习了拓扑排序以后自己写的代码
 *
 * @author liwei
 */
public class Solution {
    /**
     * @param numCourses    总共有多少门课程
     * @param prerequisites [[1,0],[1,2],[0,1]] 应该返回 false
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        // 邻接表，使用 Set 是为了去重
        HashSet<Integer>[] table = new HashSet[numCourses];
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            table[i] = new HashSet<>();
        }
        // 填写邻接表，有多少条有向边，注意：后面的结点指向前面的结点
        // 添加入度列表，列表的个数与节点个数一致
        // 填写邻接表的时候，把入度表也填了
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            table[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        // 遍历入度矩阵
        for (int i = 0; i < numCourses; i++) {
            // 每一轮都先找入度为 0 的结点，将它设置成 -1 表示已经从邻接表中删除
            int j = 0;
            while (j < numCourses && inDegree[j] != 0) {
                j++;
            }
            // 在遍历的过程中，没有找到入度为 0 的结点，说明存在环，课程学习任务就无法完成
            // 所以返回 false
            if (j == numCourses) {
                return false;
            }
            // 找到了一个入度为 0 的结点
            // 1、将它删除，即设置为 -1
            // 2、将它指向的结点的入度全部减一
            inDegree[j] = -1;
            for (int n : table[j]) {
                inDegree[n]--;
            }
        }
        return true;
    }
}