public class Solution {

    // 如果我们可以从 `s2` 中删除某些字符使其变为 `s1`，我们称字符串 `s1` 可以从字符串 `s2` 获得

    // 例如：`s1 = "abc"`，`s2 = "abdbec"`，即 s1 是 s2 的子序列（是子集、顺序要求一致、不必连续）
    // 大小写问题
    // S1 = acbacbacbacb
    // 题目问 S2 = abab
    // abababab
    // s1、s2、S1、S2

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        int index2 = 0;
        // s2 循环了几次
        int loopTimesOnS2 = 0;

        for (int i = 0; i < n1; i++) {
            for (int index1 = 0; index1 < len1; index1++) {
                if (charArray1[index1] == charArray2[index2]) {
                    index2++;

                    // 如果 index2 遍历到末尾，循环计数器加 1，index2 重置到开头
                    if (index2 == len2) {
                        index2 = 0;
                        loopTimesOnS2++;
                    }
                }
            }
        }
        return loopTimesOnS2 / n2;
    }

    public static void main(String[] args) {
        String s1 = "aceb";
        int n1 = 7;

        // aceb aceb aceb aceb aceb aceb aceb
        //    b   e  a  b   e  a  b   e  a  b ea

        // 因为顺序不同，会出现「交叉循环」的现象，只要 s1 足够长，一定可以把 s2 覆盖
        String s2 = "bea"; // 相当于给 s2 调整了一个顺序

        // 每一次一定可以找到一个

        int n2 = 1;

        Solution solution = new Solution();
        int res = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(res);
    }
}
