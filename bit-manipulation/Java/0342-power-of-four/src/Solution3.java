/**
 * @author liwei
 * @date 18/6/30 下午6:16
 */
public class Solution3 {

    /**
     * 转换成四进制数
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && Integer.toString(num,4).matches("^10*$");
    }
}
