import java.util.Arrays;

public class Solution2 {

    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] left = new int[len];
        int[] right = new int[len];

        // 注意：每个小朋友至少分到一个苹果
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 第 1 步：正反各遍历一次
        // 0 号下标不考虑
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 下标 len - 1 不考虑
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // 第 2 步：把上面的两个数组各遍历一次
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}