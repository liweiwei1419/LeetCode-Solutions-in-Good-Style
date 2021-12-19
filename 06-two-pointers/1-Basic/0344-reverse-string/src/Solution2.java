public class Solution2 {

    public String reverseString(char[] s) {
        int len = s.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
        return new String(s);
    }

    private void swap(char[] s, int index1, int index2) {
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }
}