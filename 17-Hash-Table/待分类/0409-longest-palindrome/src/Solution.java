public class Solution {

    public int longestPalindrome(String s) {
        // 转换成字符数组是常见的做法，用下标遍历 charAt(i) 会对下标进行检查
        char[] chars = s.toCharArray();

        // 手动设置哈希表，哈希函数为 c - 'A'
        // 这里的哈希表的作用是计数器
        // 由于 大写字母 'A' 与小写字母 'a' 的 ASCII 相差 32
        // 所以设置哈希表的大小为 32 + 26 = 58

        int size = 58;
        int[] map = new int[size];
        for (char c : chars) {
            map[c - 'A']++;
        }

        int res = 0;

        // 只要有单独的那个字符，就可以作为中心
        boolean center = false;
        for (int i = 0; i < size; i++) {
            if (map[i] > 0) {
                res += map[i];

                // 如果是奇数个，一定有一个字符「落单」，「落单」的这个字符可以作为中心
                if ((map[i] & 1) == 1) {
                    res -= 1;
                    center = true;
                }
            }
        }
        if (center) {
            res += 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        int res = solution.longestPalindrome(s);
        System.out.println(res);
    }
}
