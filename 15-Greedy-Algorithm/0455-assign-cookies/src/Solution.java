import java.util.Arrays;

public class Solution {

    // 输入: [1,2,3], [1,1]
    // 输出: 1
    // g 是贪心指数
    // s 是饼干的大小

    // 思路 1 ：饼干数组和小朋友的贪心指数数组都从小到大排序

    public int findContentChildren(int[] g, int[] s) {
        int glen = g.length;
        int slen = s.length;
        if (glen == 0 || slen == 0) {
            return 0;
        }
        // 贪心算法通常都和排序相关
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        int res = 0;

        while (gi < glen && si < slen) {
            if (s[si] >= g[gi]) {
                si++;
                gi++;
                res++;
            } else { // 当前这块小的饼干不能满足当前这位小朋友了，所以我们要换下一块更大一点的饼干
                si++;
            }
        }
        return res;
    }
}