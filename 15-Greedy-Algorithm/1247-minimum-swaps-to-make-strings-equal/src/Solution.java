public class Solution {

    // 3 个例题就给出了 3 种需要考虑的情况

    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        // 在 s1 是 x，在 s2 是 y 的情况
        int x2y = 0;
        // 在 s2 是 y，在 s2 是 x 的情况
        int y2x = 0;

        for (int i = 0; i < len; i++) {
            if (charArray1[i] == 'x' && charArray2[i] == 'y') {
                x2y++;
            }
            if (charArray1[i] == 'y' && charArray2[i] == 'x') {
                y2x++;
            }
        }

        // 成对的 x2y 和 y2x 都解决了以后，如果单独剩下一个位置不等，则任务不能完成，返回 -1
        if ((x2y % 2 + y2x % 2) == 1) {
            return -1;
        }

        // 示例 1
        int res = x2y / 2 + y2x / 2;
        // 示例 2
        if (x2y % 2 == 1 && y2x % 2 == 1) {
            res += 2;
        }
        return res;
    }
}