import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 贪心算法
    // 张心翮：https://blog.csdn.net/weixin_41796401/article/details/89504368

    public int twoCitySchedCost(int[][] costs) {
        // 让其以 costs[0] - costs[1] 的差值升序排序
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        // 前一半取去 A 市，后一半取去 B 市，前一半是去 A 市最合适
        // 后一半市去 B 市最合适
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }
}