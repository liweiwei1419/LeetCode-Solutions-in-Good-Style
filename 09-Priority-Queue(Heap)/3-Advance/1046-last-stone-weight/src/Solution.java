import java.util.PriorityQueue;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();
            if (head1.equals(head2)) {
                continue;
            }
            maxHeap.offer(head1 - head2);
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.poll();
    }
}