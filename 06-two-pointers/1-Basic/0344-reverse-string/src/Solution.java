public class Solution {

    public String reverseString(char[] s) {
        int len = s.length;
        if (len < 2) {
            return new String(s);
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
        return String.valueOf(s);
    }

    private void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}