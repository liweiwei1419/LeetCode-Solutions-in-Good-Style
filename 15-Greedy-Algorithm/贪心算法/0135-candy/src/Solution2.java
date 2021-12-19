public class Solution2 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }

        int res = 1;
        // 最近的、处于上升区间里的最后一个元素的值
        int up = 0;
        // 下降区间的元素的长度
        int down = 0;

        // 上升区间里，循环变量 i 的左边一个位置的小朋友得到的糖果数
        int prev = 0;

        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i]) {
                up++;
                down = 0;
                prev = up;

                res += (up + 1);
            } else if (ratings[i - 1] == ratings[i]) {
                // 不管处于上升区间还是下降区间，这三个变量都重置为 0
                up = 0;
                prev = 0;
                down = 0;

                // 不管处于上升区间还是下降区间，此时都只贪心地给当前小朋友 1 颗糖果
                res += 1;
            } else {
                // 此时处于下降区间
                up = 0;
                down++;

                if (down <= prev) {
                    res += down;
                } else {
                    res += down + 1;
                }
            }
        }
        return res;
    }
}