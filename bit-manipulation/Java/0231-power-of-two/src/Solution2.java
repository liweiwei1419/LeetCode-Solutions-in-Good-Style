/**
 * @author liwei
 * @date 18/6/30 下午9:50
 */
public class Solution2 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
