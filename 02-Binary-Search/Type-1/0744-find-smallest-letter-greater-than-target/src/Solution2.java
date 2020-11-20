public class Solution2 {

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (target >= letters[len - 1]) {
            return letters[0];
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
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