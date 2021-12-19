public class Solution2 {

    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();

        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();

        int index1 = 0;
        int index2 = 0;

        while (index2 < len2) {
            if (index1 < len1 && nameArray[index1] == typedArray[index2]) {
                index1++;
                index2++;
            } else if (index2 > 0 && typedArray[index2] == typedArray[index2 - 1]) {
                index2++;
            } else {
                return false;
            }
        }
        return index1 == nameArray.length;
    }
}