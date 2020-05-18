import java.util.Arrays;

public class Solution2 {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // 窗口内部覆盖 T 还需要的各个字符的个数
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少 T 中的字符，对应字符频数超过不重复计算
        int distance = tLen;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left..right)
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] > 0) {
                distance--;
            }

            // 对于 t 中不曾出现的字符，也减 1，值负数
            tFreq[charRight]--;
            right++;

            // System.out.println(distance + " " + s.substring(left, right));
            while (distance == 0) {
                // System.out.println("左边界收缩 " + distance + " " + s.substring(left, right));
                // System.out.println(tFreq['A'] + "," + tFreq['B'] + "," + tFreq['C']);
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                // 注意：这里要先加，加到大于 0，说明，这个字符在 t 中存在
                // 对于 t 中不曾出现的字符，加 1 以后，为 0
                if (tFreq[charLeft] >= 0) {
                    distance++;
                }
                tFreq[charLeft]++;
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = solution2.minWindow(s, t);
        System.out.println("结果：" + res);
    }
}
