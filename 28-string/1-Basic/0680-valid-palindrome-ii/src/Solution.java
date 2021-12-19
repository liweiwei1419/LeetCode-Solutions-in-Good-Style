public class Solution {

    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return validPalindrome(charArray, left + 1, right) || validPalindrome(charArray, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean validPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}