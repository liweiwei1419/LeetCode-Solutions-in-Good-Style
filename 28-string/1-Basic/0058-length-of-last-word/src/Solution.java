public class Solution {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        // 特别注意 "a " 这种特殊的测试用例
        // 特别注意 "b   a    "，因此，要使用 while
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        if (len == 0) {
            return 0;
        }

        int begin = -1;
        int index = 0;
        while (index < len) {
            char curChar = s.charAt(index);
            if (curChar == ' ') {
                begin = index;
            }
            index++;
        }
        return len - 1 - begin;
    }
}