public class Solution2 {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        // 接下来统计 a 这个数二进制中 1 的个数
        int count = 0;
        while (a != 0) {
            a = a & (a - 1);
            count++;
        }
        return count;
    }
}