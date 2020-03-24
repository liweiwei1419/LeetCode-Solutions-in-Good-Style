public class Solution {

    // 使用递归的时候，把递归方法想象成一个黑盒子
    // 个人觉得这种写法是最简洁的，我是在写完了 LeetCode 443 题以后，
    // 回过头来写这个解答的
    // https://blog.csdn.net/xygy8860/article/details/46821417

    // 这个技巧叫"哨兵"

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String preStr = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();

        int len = preStr.length();
        int duplicateTimes = 1;
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && preStr.charAt(i) == preStr.charAt(i + 1)) {
                duplicateTimes++;
            } else {

                // 在 i = len - 1 的时候，要做结算
                // 在 preStr.charAt(i) != preStr.charAt(i + 1) 的时候也要做结算
                // 可以合并在一起

                stringBuilder.append(duplicateTimes);
                stringBuilder.append(preStr.charAt(i));
                duplicateTimes = 1;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String countAndSay = solution.countAndSay(6);
        System.out.println(countAndSay);
    }
}
