import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    private List<String> result = new ArrayList<>();
    private String s;
    private int length;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.length = s.length();
        if (s.length() == 0) {
            return result;
        }
        find(0, 0, "");
        return result;
    }

    /**
     * @param begin
     * @param splitTimes 已经分割了几次
     * @param pre
     */
    private void find(int begin, int splitTimes, String pre) {
        System.out.println(begin + " " + splitTimes + " " + pre);
        // 先写递归终止条件
        if (splitTimes == 4) {
            // 已经分割了 4 次，如果 begin 的位置刚刚好等于数字字符串的长度
            // 那么此时 pre 就是我们要搜索的 ip 字符串之一
            // 注意输出的时候，要把最后一个"." 去掉
            if (begin == length) {
                System.out.println("---------------- 已经分割了 4 次以后 " + begin + " " + splitTimes + " " + pre);
                result.add(pre.substring(0, pre.length() - 1));
            } // begin < length 和 > length（之前已经被排除） 的情况显然不符合条件，可以停止搜索
            return;
        }
        String ipSegment;
        for (int i = 1; i <= 3 && begin + i <= length; i++) {
            ipSegment = s.substring(begin, begin + i);
            if (judgeIfIpSegment(ipSegment)) {// 如果它可以成为一个 ip 段
                find(begin + i, splitTimes + 1, pre + ipSegment + '.');
            }
        }
    }

    private boolean judgeIfIpSegment(String ipSegment) {
        if (ipSegment.length() > 1 && ipSegment.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(ipSegment) <= 255;
    }

    public static void main(String[] args) {
        // String input = "25525511135";
        String input = "0000";
        List<String> result = new Solution().restoreIpAddresses(input);
        System.out.println(result);
    }
}
