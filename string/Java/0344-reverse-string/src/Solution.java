public class Solution {

    public String reverseString(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverseString(chars);
        return String.valueOf(chars);
    }

    private void reverseString(char[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        String s = "hello";
        Solution solution  =new Solution();
        String reverseString = solution.reverseString(s);
        System.out.println(reverseString);
    }
}