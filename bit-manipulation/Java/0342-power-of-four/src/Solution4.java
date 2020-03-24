/**
 * @author liwei
 * @date 18/6/30 下午7:33
 */
public class Solution4 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
