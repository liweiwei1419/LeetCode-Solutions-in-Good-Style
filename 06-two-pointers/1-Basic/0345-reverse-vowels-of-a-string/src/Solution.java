public class Solution {

    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && checkVowels(charArray[left])) {
                left++;
            }
            while (left < right && checkVowels(charArray[right])) {
                right--;
            }
            if (left < right) {
                swap(charArray, left, right);
                left++;
                right--;
            }
        }
        return new String(charArray);
    }

    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    private boolean checkVowels(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
}