import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;
        if (sLen == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < gLen && sIndex < sLen) {
            // 用最小的饼干去满足贪心程度最低的小朋友
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
                sIndex++;
            } else {
                sIndex++;
            }
        }
        return gIndex;
    }
}