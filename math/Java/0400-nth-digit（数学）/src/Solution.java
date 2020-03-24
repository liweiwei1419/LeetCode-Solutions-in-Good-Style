import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    private List<String> res = new ArrayList<>();

    private int[] hourArr = {8, 4, 2, 1};
    private int[] minuteArr = {32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int num) {
        if (num > 10 || num < 0) {
            return res;
        }
        for (int i = 0; i <= num; i++) {
            // 应该定义组合
            List<Integer> hourCombination = findCombination(hourArr, i);
            List<Integer> minuteCombination = findCombination(minuteArr, num - i);
            for (int j = 0; j < hourCombination.size(); j++) {
                if (hourCombination.get(j) > 11) {
                    continue;
                }
                for (int k = 0; k < minuteCombination.size(); k++) {
                    if (minuteCombination.get(k) > 59) {
                        continue;
                    }
                    res.add(hourCombination.get(j) + ":" + (minuteCombination.get(k) < 10 ? "0" + minuteCombination.get(k) : minuteCombination.get(k)));
                }
            }
        }
        return res;
    }


    private List<Integer> findCombination(int[] arr, int count) {
        List<Integer> res = new ArrayList<>();
        findCombination(arr, count, 0, new Stack<>(), res);
        return res;
    }


    private Integer sum(List<Integer> pre) {
        int sum = 0;
        for (int i = 0; i < pre.size(); i++) {
            sum += pre.get(i);
        }
        return sum;
    }

    private void findCombination(int[] arr, int count, int start, Stack<Integer> pre, List<Integer> res) {
        if (pre.size() == count) {
            res.add(sum(pre));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            pre.push(arr[i]);
            findCombination(arr, count, i + 1, pre, res);
            pre.pop();
        }
    }


    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        List<String> readBinaryWatch = solution.readBinaryWatch(2);
        System.out.println(readBinaryWatch);


    }
}
