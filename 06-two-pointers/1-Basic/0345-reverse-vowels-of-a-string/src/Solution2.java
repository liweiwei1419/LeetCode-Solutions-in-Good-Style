public class Solution2 {

    // 这种写法比较慢

    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && judgeVowels(charArray[left])) {
                left++;
            }
            while (left < right && judgeVowels(charArray[right])) {
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

    private void swap(char[] charArr, int index1, int index2) {
        char temp = charArr[index1];
        charArr[index1] = charArr[index2];
        charArr[index2] = temp;
    }

    private boolean judgeVowels(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }

//    private boolean judgeVowels(char c) {
//        return !(c + "").matches("[aeiouAEIOU]");
//    }
}