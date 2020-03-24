/**
 * @author liwei
 * @date 18/7/1 下午7:38
 */
public class Solution6 {

    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        while (n != 0) {
            count += (n & mask);
            n >>>= 1;
        }
        return count;
    }
}
