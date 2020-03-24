public class Solution {

    public String reverseWords(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] charArr = s.toCharArray();
        int begin = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                reverseCharArray(charArr, begin, i - 1);
                begin = i + 1;
            }
        }
        reverseCharArray(charArr, begin, len - 1);
        return String.valueOf(charArr);
    }

    private void reverseCharArray(char[] arr, int index1, int index2) {
        while (index1 < index2) {
            swap(arr, index1, index2);
            index1++;
            index2--;
        }
    }

    private void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        // 输入: "Let's take LeetCode contest"
        // 输出: "s'teL ekat edoCteeL tsetnoc"
        String s = "Let's take LeetCode contest";
        Solution solution =new Solution();
        String reverseWords = solution.reverseWords(s);
        System.out.println(reverseWords);
    }
}
