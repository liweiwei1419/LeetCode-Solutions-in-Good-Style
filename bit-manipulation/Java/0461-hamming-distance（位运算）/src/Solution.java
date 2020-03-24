/**
 * @author liwei
 * @date 18/7/1 下午4:03
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int count = 0;
        while (a != 0) {
            a = a & (a - 1);
            count++;
        }
        return count;
    }
}
