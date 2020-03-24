/**
 * @author liweiwei1419
 * @date 2019/10/15 7:05 下午
 */
public class Solution4 {

    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }

        return res;
    }

    public int reverseBits(int n) {
        int res = 0;
        // 注意：外层循环是 32，里面那个是 31
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
}
