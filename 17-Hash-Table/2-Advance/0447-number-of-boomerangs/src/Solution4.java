import java.util.HashMap;
import java.util.Map;


public class Solution4 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
            // 其它的点
            for (int[] other : points) {
                // 距离自己，可以不用管，因为自己到自己的距离为 0
                int distance = distance(point, other);
                if (map.containsKey(distance)) {
                    Integer count = map.get(distance);
                    // 把已经有的乘以 2
                    res += count;
                    map.put(distance, count + 1);
                } else {
                    map.put(distance, 1);
                }
            }
        }
        return res * 2;
    }

    private int distance(int[] point1, int[] point2) {
        int diffX = point1[0] - point2[0];
        int diffY = point1[1] - point2[1];
        return diffX * diffX + diffY * diffY;
    }
}