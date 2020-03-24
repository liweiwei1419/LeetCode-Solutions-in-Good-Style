// https://leetcode-cn.com/problems/remove-k-digits/description/
// 402. 移掉K位数字
// Solution 和 Solution2 都是一样的
// 参考资料：https://blog.csdn.net/mebiuw/article/details/52576884
// https://blog.csdn.net/qq508618087/article/details/52584133
// 
// 
public class Solution {
    // 这道题细节很多，要注意
    // 思路：一个一个地删除
    public String removeKdigits(String num, int k) {
        int n;
        while (true) {
            n = num.length();
            if (k >= n || n == 0) {
                return "0";
            }
            if (k == 0) {
                return num;
            }
            // 表示接下来我一定会删除至少一个元素
            k--;
            // 如果第 2 位是 '0'，那么我是一定要删掉 num[0] 和那些 '0' 的
            // s = "40089"
            if (num.charAt(1) == '0') {
                int notZeroBegin = 1;
                while (notZeroBegin < n && num.charAt(notZeroBegin) == '0') {
                    notZeroBegin++;
                }
                num = num.substring(notZeroBegin);
            } else { // 找递增序列的最后一个，把它删掉
                // s = "1234521"
                int increaseLast = 0;
                while (increaseLast < n - 1) {
                    int cur = num.charAt(increaseLast) - '0';
                    int next = num.charAt(increaseLast + 1) - '0';
                    if (cur <= next) {
                        increaseLast++;
                    } else {
                        break;
                    }
                }
                num = num.substring(0, increaseLast) + num.substring(increaseLast + 1);
            }
        }
    }

    public static void main(String[] args) {
        String num = "5337";
        int k = 2;
        Solution solution = new Solution();
        String removeKdigits = solution.removeKdigits(num, k);
        System.out.println(removeKdigits);
    }
}
