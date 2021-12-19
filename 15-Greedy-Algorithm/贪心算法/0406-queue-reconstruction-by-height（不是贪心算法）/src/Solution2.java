import java.util.Arrays;

public class Solution2 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });

        int len = people.length;
        int[][] res = new int[len][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < len; ++i) {
                if (res[i] == null) {
                    spaces--;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}