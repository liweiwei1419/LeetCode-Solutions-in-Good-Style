public class Solution2 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countAndSay("1", 1, n);
    }

    /**
     * @param pre
     * @param index
     * @param n
     * @return
     */
    private String countAndSay(String pre, int index, int n) {
        if (index == n) {
            return pre;
        }
        pre = pre + "#";
        StringBuilder stringBuilder = new StringBuilder();
        int len = pre.length();
        int duplicateTimes = 1;
        for (int i = 0; i < len - 1; i++) {
            if (pre.charAt(i) == pre.charAt(i + 1)) {
                duplicateTimes++;
            } else {
                stringBuilder.append(duplicateTimes);
                stringBuilder.append(pre.charAt(i));
                duplicateTimes = 1;
            }
        }
        return countAndSay(stringBuilder.toString(), index + 1, n);
    }
}
