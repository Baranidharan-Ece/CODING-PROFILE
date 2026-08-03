import java.util.*;

class Solution {
    int[] parent;
    TreeMap<Integer, TreeSet<Integer>> gridMap = new TreeMap<>();

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        // Build DSU connections
        for (int[] edge : connections) {
            union(edge[0], edge[1]);
        }

        // Build TreeSet for each grid root
        Map<Integer, TreeSet<Integer>> grid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i);
            grid.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        // Track online status
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for (int[] q : queries) {
            int type = q[0], x = q[1];

            if (type == 1) { // maintenance query
                if (online[x]) {
                    res.add(x);
                } else {
                    int root = find(x);
                    TreeSet<Integer> set = grid.get(root);
                    if (set == null || set.isEmpty()) res.add(-1);
                    else res.add(set.first());
                }
            } else { // type == 2, go offline
                if (!online[x]) continue;
                online[x] = false;
                int root = find(x);
                TreeSet<Integer> set = grid.get(root);
                if (set != null) set.remove(x);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
