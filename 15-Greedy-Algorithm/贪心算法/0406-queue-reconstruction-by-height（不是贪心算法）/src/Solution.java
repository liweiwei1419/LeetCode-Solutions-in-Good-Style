import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // 这题很奇葩，几乎没有考到有用的知识点


    // 考虑倒排身高，这样前面有多少个比他高的人就已知了
    // 假设某个队列排到 <h,i>，对于前面的人来说，身高都 ≥ 他，所以当他插入第 i 个位置的时候，对其他人是不产生影响的
    // 这是因为当身高一致，i 会正序排序
    // 参考资料：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/java-zi-ding-yi-pai-xu-cha-ru-by-ppppjqute/

    public int[][] reconstructQueue(int[][] people) {
        // 预处理很关键
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                // 身高递减
                return -o1[0] + o2[0];
            }
            // 身高相同的时候，前面的人的个数按照递增来
            return o1[1] - o2[1];
        });

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            // 难点：第 1 个参数是位置
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution solution = new Solution();
        int[][] res = solution.reconstructQueue(people);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}