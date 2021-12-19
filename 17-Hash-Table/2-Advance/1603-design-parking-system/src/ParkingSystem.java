public class ParkingSystem {

    // 哈希表

    /**
     * 容量，初始化的时候固定好的
     */
    private int[] capacity;
    /**
     * 当前已经使用的数量
     */
    private int[] used;

    public ParkingSystem(int big, int medium, int small) {
        // 0 这个位置是空出来的
        capacity = new int[4];
        used = new int[4];
        capacity[1] = big;
        capacity[2] = medium;
        capacity[3] = small;
    }

    public boolean addCar(int carType) {
        if (capacity[carType] == used[carType]) {
            // == 表示已经满了，所以返回 false
            return false;
        }
        used[carType]++;
        return true;
    }
}