public class Solution2 {

    // 参考：https://www.cnblogs.com/grandyang/p/10447783.html
    // 我想到了双指针，但是没有想到从后向前遍历，还有具体的细节懒得想了，优化了原作者的代码

    public boolean backspaceCompare(String S, String T) {
        char[] charArray1 = S.toCharArray();
        char[] charArray2 = T.toCharArray();

        int len1 = S.length();
        int len2 = T.length();

        // 连续出现 # 的个数
        int cnt1 = 0;
        int cnt2 = 0;

        int i = len1 - 1;
        int j = len2 - 1;

        while (i >= 0 || j >= 0) {

            // 逻辑上应该先处理 # 号

            while (i >= 0 && (charArray1[i] == '#' || cnt1 > 0)) {
                if (charArray1[i] == '#') {
                    cnt1++;
                } else {
                    cnt1--;
                }
                i--;
            }

            while (j >= 0 && (charArray2[j] == '#' || cnt2 > 0)) {
                if (charArray2[j] == '#') {
                    cnt2++;
                } else {
                    cnt2--;
                }
                j--;
            }

            // 这里处理数组下标越界的情况
            if (i < 0 || j < 0) {
                return i == j;
            }

            // 这是最简单的情况
            if (charArray1[i] != charArray2[j]) {
                return false;
            }

            // 然后继续向前遍历
            j--;
            i--;
        }

        // 细节特别多，到这里就完了
        return i == j;
    }
}
