import java.util.ArrayList;
import java.util.List;


public class Solution2 {

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
        findCombination(arr, count, 0, 0, res);
        return res;
    }

    private void findCombination(int[] arr, int count, int start, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            findCombination(arr, count - 1, i + 1, sum + arr[i], res);
        }
    }
}