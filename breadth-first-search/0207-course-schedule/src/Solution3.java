import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 根据如下参考资料写出的代码：同 Solution 和 Solution2 是一样的
 * 参考资料：https://blog.csdn.net/ljiabin/article/details/45846837
 * @author liwei
 * @date 18/6/23 下午10:17
 */
public class Solution3 {
    // [1,0] 表示 学习课程 1 之前，你需要完成课程 0。所以这是可能的。
    // [1,0] 表示 0 指向 1，即 后面的指向前面的

    /**
     * @param numCourses    总共有多少门课程
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init the adjacency list（
        // 初始化邻接表（也可以使用数组）
        List<Set<Integer>> posts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new HashSet<>());
        }
        // fill the adjacency list
        // 把邻边信息填写到邻接表里面
        for (int[] p : prerequisites) {
            posts.get(p[1]).add(p[0]);
        }
        // count the pre-courses
        // 计算每一个结点的入度，用一个数组存起来
        int[] preNums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // set 中的结点都是"被指向的结点"
            Set<Integer> set = posts.get(i);
            for (Integer num : set) {
                preNums[num]++;
            }
        }
        // remove a non-pre course each time
        // 每一次删除一个没有前驱的结点
        for (int i = 0; i < numCourses; i++) {
            // find a non-pre course
            // 找到第 1 个入度为 0 的结点
            int j = 0;
            for (; j < numCourses; j++) {
                if (preNums[j] == 0) {
                    break;
                }
            }
            // if not find a non-pre course
            // 在遍历的过程中，如果都没有入度为 0 的结点，就表示图中有环
            // 返回错误
            if (j == numCourses) {
                return false;
            }
            // 找到入度为 0 的结点，设置成 -1 ，表示从图中删除
            preNums[j] = -1;
            // decrease courses that post the course
            // 这些结点原来都是 j 指向他们
            Set<Integer> set = posts.get(j);
            for (int num : set) {
                preNums[num]--;
            }
        }
        return true;
    }
}

