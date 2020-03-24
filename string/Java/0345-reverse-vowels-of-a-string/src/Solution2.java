public class Solution2 {
    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (l < len && !judgeVowels(chars[l])) {
                l++;
            }
            while (r > 0 && !judgeVowels(chars[r])) {
                r--;
            }
            if (l < r) {
                swap(chars, l, r);
                l++;
                r--;
            }

        }
        return String.valueOf(chars);
    }

    private void swap(char[] charArr, int index1, int index2) {
        char temp = charArr[index1];
        charArr[index1] = charArr[index2];
        charArr[index2] = temp;
    }

    private boolean judgeVowels(char c) {
        return (c + "").matches("[aeiouAEIOU]");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String reverseVowels = solution.reverseVowels("hello");
        System.out.println(reverseVowels);
    }
}