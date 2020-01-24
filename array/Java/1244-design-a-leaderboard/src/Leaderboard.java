/**
 * @author liweiwei1419
 * @date 2019/11/2 10:31 下午
 */
public class Leaderboard {

    // 树状数组不行，题目要求的是排名，这一版代码保留，请忽略


    /**
     * 预处理数组
     */
    private int[] tree;

    /**
     * 在 i 之前有多少元素被重置了
     */
    private int[] board;
    private int len = 10000;

    private int endId = 0;

    public Leaderboard() {
        tree = new int[len + 1];
        board = new int[len + 1];
    }

    public void addScore(int playerId, int score) {
        update(playerId, score, tree);
        update(playerId, 1, board);
    }

    public int top(int K) {
        // 在榜单上的人数
        int onLeaderboard = query(K , board);

        // 加上不在榜单上的人数
        int a = K - onLeaderboard;
        System.out.println("空缺人数 => " + a);
        K += a;
        return query(K,tree);
    }

    // 1 1 1 1 1 表示有成绩，0 表示没有成绩

    public void reset(int playerId) {
        int score = query(playerId, tree) - query(playerId - 1, tree);
        update(playerId, -score, tree);
        update(playerId, -1, board);
    }

    /**
     * 查询前缀和
     *
     * @param i 前缀的最大索引，即查询区间 [0, i] 的所有元素之和
     */
    private int query(int i, int[] nums) {
        // 从右到左查询
        int sum = 0;
        while (i > 0) {
            sum += nums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    /**
     * 单点更新
     *
     * @param i     原始数组索引 i
     * @param delta 变化值 = 更新以后的值 - 原始值
     */
    private void update(int i, int delta, int[] nums) {
        // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
        while (i <= len) {
            nums[i] += delta;
            i += lowbit(i);
        }
    }


    public static int lowbit(int x) {
        return x & (-x);
    }


    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 78);
        leaderboard.addScore(2, 60);
        leaderboard.addScore(3, 84);
        leaderboard.addScore(4, 7);
        leaderboard.addScore(5, 61);


        System.out.println(leaderboard.top(1));
    }
}
