/// Source : https://leetcode.com/problems/assign-cookies/description/
/// Author : liuyubobobo
/// Time   : 2018-01-17
import java.util.Arrays;

/// Greedy Algorithm
/// Serve least greedy children first
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)
public class Solution2 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;
        int res = 0;
        while(gi < g.length && si < s.length){
            if(s[si] >= g[gi]){
                res ++;
                gi ++;
            }
            si ++;
        }

        return res;
    }

    public static void main(String[] args) {

        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new Solution2()).findContentChildren(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new Solution2()).findContentChildren(g2, s2));
    }
}
