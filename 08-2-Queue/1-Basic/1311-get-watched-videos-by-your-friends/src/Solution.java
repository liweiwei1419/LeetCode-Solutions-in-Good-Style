import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int len = friends.length;
        // 距离 id 的步数，借助队列，初值为 -1 表示还没有赋值
        int[] distance = new int[len];
        Arrays.fill(distance, -1);

        distance[id] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        while (!queue.isEmpty()) {
            Integer top = queue.poll();

            for (int friend : friends[top]) {
                if (distance[friend] == -1) {
                    distance[friend] = distance[top] + 1;
                    queue.offer(friend);
                }
            }
        }

        List<String> res = new ArrayList<>();
        // 以下同「力扣」第 451 题：根据字符出现频率排序
        // 存储了距离为 level 的朋友所看的电影和对应的观看次数
        Map<String, Integer> vatchedTimes = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 只关心距离为 level 的朋友所看的电影
            if (distance[i] == level) {
                for (String video : watchedVideos.get(i)) {
                    if (vatchedTimes.get(video) == null) {
                        res.add(video);
                        vatchedTimes.put(video, 0);
                    } else {
                        vatchedTimes.put(video, vatchedTimes.get(video) + 1);
                    }
                }
            }
        }

        res.sort((v1, v2) -> {
            if (!vatchedTimes.get(v1).equals(vatchedTimes.get(v2))) {
                return vatchedTimes.get(v1) - vatchedTimes.get(v2);
            }

            return v1.compareTo(v2);
        });
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();

        List<String> video1 = new ArrayList<>();
        video1.add("A");
        video1.add("B");

        List<String> video2 = new ArrayList<>();
        video2.add("C");


        List<String> video3 = new ArrayList<>();
        video3.add("B");
        video3.add("C");

        List<String> video4 = new ArrayList<>();
        video4.add("D");

        watchedVideos.add(video1);
        watchedVideos.add(video2);
        watchedVideos.add(video3);
        watchedVideos.add(video4);

        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        int id = 0;
        int level = 2;

        Solution solution = new Solution();
        List<String> res = solution.watchedVideosByFriends(watchedVideos, friends, id, level);
        System.out.println(res);
    }
}