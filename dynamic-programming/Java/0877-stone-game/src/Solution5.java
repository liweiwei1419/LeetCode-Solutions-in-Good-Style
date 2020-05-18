public class Solution5 {

    // Alex 总是赢得 2 堆时的游戏
    // 通过一些努力，我们可以获知他总是赢得 4 堆时的游戏

    // 反推
    // 如果 Alex 最初获得第一堆，她总是可以拿第三堆
    // 如果他最初取到第四堆，她总是可以取第二堆。

    // [重点]
    // 比较：第一 + 第三，第二 + 第四 中的至少一组是更大的，所以她总能获胜

    public boolean stoneGame(int[] piles) {
        return true;
    }

}