public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        char[] charArray = moves.toCharArray();
        for (char move : charArray) {
            if (move == 'U') {
                y--;
            } else if (move == 'D') {
                y++;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}