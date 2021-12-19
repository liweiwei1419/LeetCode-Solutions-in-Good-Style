import java.util.Arrays;


public class Solution2 {

    // 思路 2：给最贪心的小朋友最大的饼干

    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;
        if (sLen == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = gLen - 1;
        int sIndex = sLen - 1;
        int res = 0;
        while (gIndex >= 0 && sIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                sIndex--;
                gIndex--;
                res++;
            } else {
                gIndex--;
            }
        }
        return res;
    }
}