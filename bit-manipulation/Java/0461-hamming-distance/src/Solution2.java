/**
 * @author liweiwei1419
 * @date 2019/10/24 4:48 下午
 */
public class Solution2 {
    public int hammingDistance(int x, int y) {
        StringBuilder xx = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder yy = new StringBuilder(Integer.toBinaryString(y));

        // 如果都是负数，Integer.toBinaryString(x) 一定都是 32 位，就没有必要做补齐的判断和操作了
        boolean bothNegative = x < 0 && y < 0;
        if (!bothNegative) {
            // 始终让 xx 是长度比较小的那个字符串，这样补齐总是在 x 的前面补 0
            if (xx.length() > yy.length()) {
                StringBuilder temp = xx;
                xx = yy;
                yy = temp;
            }
            int diff = yy.length() - xx.length();
            for (int i = 0; i < diff; i++) {
                xx.insert(0, '0');
            }
        }
        int sum = 0;
        for (int i = 0; i < yy.length(); i++) {
            if (xx.charAt(i) != yy.charAt(i)) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int x = -1;
        int y = -2;
        int res = solution.hammingDistance(x, y);
        System.out.println(res);
    }

}
