import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution4 {

    // 参考：https://github.com/liuyubobobo/Play-Leetcode/blob/master/0001-0500/0218-The-Skyline-Problem/cpp-0218/main.cpp

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Coordinate compression
        Set<Integer> unique_points = new HashSet<>();
        for (int[] building : buildings) {
            unique_points.add(building[0]);
            unique_points.add(building[1] - 1);
            unique_points.add(building[1]);
        }

        Map<Integer, Integer> indexes = new HashMap<>();

        List<Integer> pos = new ArrayList<>();
        for (int p : unique_points) {
            indexes.put(p, pos.size());
            pos.add(p);
        }

        // segment tree
        SegmentTree stree = new SegmentTree(pos.size());
        for (int[] building : buildings) {
            stree.add(indexes.get(building[0]), indexes.get(building[1] - 1), building[2]);
        }


        List<List<Integer>> res = new ArrayList<>();
        unique_points.clear();

        for (int[] building : buildings) {
            unique_points.add(building[0]);
            unique_points.add(building[1]);
        }

        int last = 0;
        for (int p : unique_points) {
            int h = stree.query(indexes.get(p));
            if (h != last) {
                res.add(Arrays.asList(p, h));
            }
            last = h;
        }

        return res;
    }

    private class SegmentTree {

        private int[] tree;
        private int[] lazy;
        private int n;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
            this.lazy = new int[4 * n];
        }

        public void add(int l, int r, int h) {
            update(0, 0, n - 1, l, r, h);
        }

        public int query(int index) {
            return query(0, 0, n - 1, index);
        }


        private void update(int treeID, int treeL, int treeR, int l, int r, int h) {
            if (lazy[treeID] != 0) {
                tree[treeID] = Math.max(tree[treeID], lazy[treeID]); // max
                if (treeL != treeR) {
                    lazy[2 * treeID + 1] = Math.max(lazy[treeID], lazy[2 * treeID + 1]); // max
                    lazy[2 * treeID + 2] = Math.max(lazy[treeID], lazy[2 * treeID + 2]); // max
                }
                lazy[treeID] = 0;
            }

            if (treeL == l && treeR == r) {
                tree[treeID] = Math.max(tree[treeID], h); // max
                if (treeL != treeR) {
                    lazy[2 * treeID + 1] = Math.max(h, lazy[2 * treeID + 1]); // max
                    lazy[2 * treeID + 2] = Math.max(h, lazy[2 * treeID + 2]); // max
                }
                return;
            }

            int mid = (treeL + treeR) / 2;

            if (r <= mid) {
                update(2 * treeID + 1, treeL, mid, l, r, h);
            } else if (l >= mid + 1) {
                update(2 * treeID + 2, mid + 1, treeR, l, r, h);
            } else {
                update(2 * treeID + 1, treeL, mid, l, mid, h);
                update(2 * treeID + 2, mid + 1, treeR, mid + 1, r, h);
            }
        }

        int query(int treeID, int treeL, int treeR, int index) {

            if (lazy[treeID] != 0) {
                tree[treeID] = Math.max(tree[treeID], lazy[treeID]); // max
                if (treeL != treeR) {
                    lazy[2 * treeID + 1] = Math.max(lazy[treeID], lazy[2 * treeID + 1]); // max
                    lazy[2 * treeID + 2] = Math.max(lazy[treeID], lazy[2 * treeID + 2]); // max
                }
                lazy[treeID] = 0;
            }

            if (treeL == treeR) {
                assert (treeL == index);
                return tree[treeID];
            }

            int mid = (treeL + treeR) / 2;
            if (index <= mid) {
                return query(2 * treeID + 1, treeL, mid, index);
            }
            return query(2 * treeID + 2, mid + 1, treeR, index);
        }
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{0, 2147483647, 2147483647}};
        Solution4 solution4 = new Solution4();
        List<List<Integer>> res = solution4.getSkyline(buildings);
        System.out.println(res);
    }
}
