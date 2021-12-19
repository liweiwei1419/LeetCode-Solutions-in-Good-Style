public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();

        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (nameArray[i] == typedArray[j]) {
                i++;
                j++;
                // 说明：这个 continue 很重要，看题目示例 3
                continue;
            }

            if (j > 0 && typedArray[j - 1] == typedArray[j]) {
                j++;
                continue;
            }
            return false;
        }

        if (i != len1) {
            return false;
        }

        while (j < len2) {
            if (typedArray[j] != typedArray[j - 1]) {
                return false;
            }
            j++;
        }
        return true;
    }
}