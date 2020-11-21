import java.util.HashMap;
import java.util.Map;


public class Solution {

    // 参考资料
    // https://www.jianshu.com/p/6bdb4b6cd1a1
    // https://blog.csdn.net/sscssz/article/details/53074351

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                int distance = distance(points[i], points[j]);
                if (!map.containsKey(distance)) {
                    // 这一步不太好理解
                    map.put(distance, 0);
                }
                // 这一步不太好理解
                Integer num = map.get(distance);
                res += num * 2;
                map.put(distance, num + 1);
            }
        }
        return res;
    }

    private int distance(int[] point1, int[] point2) {
        int diffX = point1[0] - point2[0];
        int diffY = point1[1] - point2[1];
        return diffX * diffX + diffY * diffY;
    }
}