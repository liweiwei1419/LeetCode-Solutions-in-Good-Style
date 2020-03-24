import java.util.ArrayList;

/**
 * @author liwei
 * @date 18/6/24 下午12:08
 */
public class Solution2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        // 与 Solution（第 1 版） 只有这里不同，用 List 也是完全可以的
        // 因为重复的边，在计算入度的时候，也是重复的
        ArrayList<Integer>[] table = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            table[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            table[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            while (j < numCourses && inDegree[j] != 0) {
                j++;
            }
            if (j == numCourses) {
                return false;
            }
            inDegree[j] = -1;
            for (int n : table[j]) {
                inDegree[n]--;
            }
        }
        return true;
    }
}
