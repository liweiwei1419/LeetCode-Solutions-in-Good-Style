import java.util.HashMap;
import java.util.Map;


public class Solution2 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] other : points) {
                int distance = distance(point, other);
                if (map.containsKey(distance)) {
                    Integer count = map.get(distance);
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