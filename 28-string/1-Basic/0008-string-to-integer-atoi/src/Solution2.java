public class Solution2 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int help = 0;
        if (str.charAt(0) != '-' || str.charAt(0) < '1' || str.charAt(0) > '9') {
            return 0;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                help = i;
                break;
            }
        }
        str = str.substring(0, help);
        return Integer.parseInt(str);
    }
}