
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    private List<String> resInt = new ArrayList<>();
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() > 12 || s.length() <= 0) {
            return res;
        }
        int splitTime = 0;
        splitStringToIp(s, 0, splitTime, resInt);
        return res;
    }


    private void splitStringToIp(String s, int start, int splitTime, List<String> pre) {
        // 这道题我失误在递归终止条件没有想清楚
        if (splitTime == 4) {
            if (start == s.length()) {
                res.add(transformToString(pre));
            }
        } else {
            for (int i = 0; i < 3 && start + i < s.length(); i++) {
                String currentNum = s.substring(start, start + i + 1);
                if (judgeStringIfIpNum(currentNum)) {
                    splitTime++;
                    pre.add(currentNum);
                    splitStringToIp(s, start + i + 1, splitTime, pre);
                    pre.remove(pre.size() - 1);
                    splitTime--;
                }
            }
        }
    }

    private String transformToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(".");
            }
        }
        return sb.toString();
    }

    // 这个函数要写清楚
    private boolean judgeStringIfIpNum(String s) {
        int len = s.length();
        if (s == null || len == 0 || len > 3) {
            return false;
        }
        if (len > 1 && s.startsWith("0")) {
            return false;
        }
        return Integer.valueOf(s) <= 255;
    }

    public static void main(String[] args) {
        String num = "010010";
        Solution solution = new Solution();
        List<String> restoreIpAddresses = solution.restoreIpAddresses(num);
        for (String s : restoreIpAddresses) {
            System.out.println(s);
        }
    }
}
