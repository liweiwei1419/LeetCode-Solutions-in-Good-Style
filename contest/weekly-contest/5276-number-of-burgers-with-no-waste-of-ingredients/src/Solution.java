import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/12/1 11:26 上午
 */
public class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>(2);
        if ((tomatoSlices & 1) != 0) {
            return res;
        }
        int x = tomatoSlices / 2 - cheeseSlices;
        int y = cheeseSlices - x;
        if (x >= 0 && y >= 0) {
            res.add(x);
            res.add(y);
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
//        int tomatoSlices = 16;
//        int cheeseSlices = 7;

//        int tomatoSlices = 17;
//        int cheeseSlices = 4;

//        int tomatoSlices = 4;
//        int cheeseSlices = 17;

//        int tomatoSlices = 0;
//        int cheeseSlices = 0;

        int tomatoSlices = 2;
        int cheeseSlices = 1;

        Solution solution = new Solution();
        List<Integer> res = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        System.out.println(res);
    }

}
