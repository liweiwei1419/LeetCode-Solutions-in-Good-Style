import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liweiwei1419
 * @date 2019/11/2 10:31 下午
 */
public class Leaderboard2 {

    /**
     * int[] 只保存 2 个值：第 1 个是分数（降序排序），第 2 个是 playId
     */
    private Set<int[]> set;
    private Map<Integer, Integer> map;

    public Leaderboard2() {
        set = new TreeSet<>((o1, o2) -> {
            // 如果分数一样，按照 playId 升序排序
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            int oldScore = map.get(playerId);
            int newScore = oldScore + score;
            map.put(playerId, newScore);

            set.remove(new int[]{oldScore, playerId});
            set.add(new int[]{newScore, playerId});
        } else {
            map.put(playerId, score);
            set.add(new int[]{score, playerId});
        }
    }

    public int top(int K) {
        int res = 0;

        Iterator<int[]> iterator = set.iterator();
        while (iterator.hasNext() && K > 0) {
            K--;
            res += iterator.next()[0];
        }
        return res;
    }

    public void reset(int playerId) {
        int oldScore = map.get(playerId);
        set.remove(new int[]{oldScore, playerId});
        map.put(playerId, 0);
        set.add(new int[]{0, playerId});
    }

    public static void main(String[] args) {
        Leaderboard2 leaderboard = new Leaderboard2();
        leaderboard.addScore(1, 73);
        leaderboard.addScore(2, 56);
        leaderboard.addScore(3, 39);
        leaderboard.addScore(4, 51);
        leaderboard.addScore(5, 4);


        System.out.println(leaderboard.map);

        Iterator<int[]> iterator = leaderboard.set.iterator();
        while (iterator.hasNext()){
            System.out.println(Arrays.toString(iterator.next()));
        }

        leaderboard.reset(1);
        leaderboard.reset(2);


        leaderboard.addScore(2, 51);


        System.out.println(leaderboard.top(3));
    }

}
