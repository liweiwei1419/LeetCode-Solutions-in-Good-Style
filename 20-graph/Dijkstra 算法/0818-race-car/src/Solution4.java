import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution4 {

    // 方法三：暴力BFS

    public int racecar(int target) {
        State initState = new State(0, 1);
        Queue<State> queue = new LinkedList<>();
        queue.add(initState);

        Set<State> visited = new HashSet<>(Math.max(target, 64));
        visited.add(initState);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                State[] nextStates = state.move();
                if (nextStates[0].getPosition() == target) {
                    return count + 1;
                }

                // 剪枝
                if (nextStates[0].getPosition() < 0) {
                    continue;
                }

                // 去重
                if (!visited.contains(nextStates[0])) {
                    queue.add(nextStates[0]);
                    visited.add(nextStates[0]);
                }
                if (!visited.contains(nextStates[1])) {
                    queue.add(nextStates[1]);
                    visited.add(nextStates[1]);
                }
            }
            count += 1;
        }
        return -1;
    }

    private class State {

        private int position;
        private int speed;

        public State(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        public int getPosition() {
            return position;
        }

        public State[] move() {
            return new State[]{
                    new State(position + speed, speed * 2),
                    new State(position, speed > 0 ? -1 : 1),
            };
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State that = (State) o;
            return position == that.position && speed == that.speed;
        }

        @Override
        public int hashCode() {
            return position + speed * speed * 500000;
        }
    }
}