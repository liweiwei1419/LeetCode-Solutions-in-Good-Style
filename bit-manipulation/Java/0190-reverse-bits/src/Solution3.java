/**
 * @author liwei
 * @date 18/7/1 下午7:47
 */
public class Solution3 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        // 输入: 43261596
        // 输出: 964176192
        System.out.println(43261596);
        Solution3 solution3 = new Solution3();
        int reverseBits = solution3.reverseBits(43261596);
        System.out.println(reverseBits);
    }
}
