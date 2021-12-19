public class Solution {

    public String reverseWords(String s) {
        // 去掉前后的空格，并且将一个空格以上的空格替换成一个空格
        s = s.trim().replaceAll("\\s+", " ");

        int len = s.length();
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, len - 1);

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == ' ') {
                reverse(charArray, index, i - 1);
                index = i + 1;
            }
        }
        reverse(charArray, index, len - 1);
        return String.valueOf(charArray);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}