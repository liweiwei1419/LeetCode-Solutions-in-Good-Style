public class Solution3 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int res = 1;

        // 上升序列的最后一个元素的值
        int inc = 1;
        // 下降序列的长度
        int dec = 0;
        // 上一个位置的小朋友分到了多少糖果，初始化的时候显然为 1
        int pre = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                // 上升
                dec = 0;
                if (ratings[i - 1] == ratings[i]) {
                    pre = 1;
                } else {
                    pre++;
                }
                res += pre;
                inc = pre;
            } else {
                // 下降的时候，当前位置肯定拿 1 个糖果
                pre = 1;

                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
            }
        }
        return res;
    }
}