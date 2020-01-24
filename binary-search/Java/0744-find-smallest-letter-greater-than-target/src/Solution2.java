/**
 * @author liweiwei1419
 * @date 2019/11/27 8:45 上午
 */
public class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;

        if (target >= letters[len - 1]) {
            return letters[0];
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target) {
                // 下一轮搜索的区间是：[mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }
}
