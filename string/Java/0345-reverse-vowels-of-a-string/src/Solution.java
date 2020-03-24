/**
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class Solution {
    /**
     * 写多了就知道，这是套路了
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        ;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (true) {
            while (i < chars.length && !checkVowels(chars[i])) {
                i++;
            }
            while (j >= 0 && !checkVowels(chars[j])) {
                j--;
            }
            if (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    private boolean checkVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.reverseVowels("hello");
        System.out.println(result1);
        String result2 = solution.reverseVowels("leetcode");
        System.out.println(result2);
        String result3 = solution.reverseVowels(" ");
        System.out.println(result3);
    }
}
