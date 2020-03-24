/**
 * 相对好理解，并且写法简单
 *
 * @author liwei
 * @date 18/7/1 下午4:11
 */
public class Solution2 {

    //
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len < 2) {
            return false;
        }
        // 5 到 2 为止 0，1，2，3，4
        // 6 到 3 为止 0，1，2，3，4，5
        // 7 到 3 为止 0，1，2，3，4，5，6
        // i 表示重复单元的长度
        for (int i = 1; i <= len / 2; i++) {
            // 如果不能被重复单元整除，那么也就不符合题意
            if (len % i != 0) {
                continue;
            }
            int j = i;
            // 下面这个逻辑判断是关键
            while (j < len && s.charAt(j) == s.charAt(j % i)) {
                j++;
            }
            if (j == len) {
                // 如果存在就马上返回
                return true;
            }
        }
        // 存在性问题，如果全部都判断完毕都不能返回 true，就得返回 false
        return false;
    }
}
