// Kruskal for MST

class Solution {
    private int findRoot(int[] parents, int p) {
        int root = p;
        if (parents[p] != p) {
            root = findRoot(parents, parents[p]);
        }
        return root;
    }
    
    private void connect(int[] parents, int root1, int root2) {
        parents[root1] = root2;
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] p) {
        // Add dummy well to the pipes list
        List<int[]> pipes = new ArrayList<>();
        for (int[] a : p)    pipes.add(a);
        for (int i = 0; i < n; i++)    pipes.add(new int[]{n + 1, i + 1, wells[i]});
        
        Collections.sort(pipes, (a, b) -> a[2] - b[2]);
        
        // Find MST tree and add cost to result
        int[] parents = new int[n + 2];
        for (int i = 1; i <= n + 1; i++)    parents[i] = i;
        
        int res = 0;
        for (int i = 0; i < pipes.size(); i++) {
            int p1 = pipes.get(i)[0], p2 = pipes.get(i)[1], cost = pipes.get(i)[2];
            int root1 = findRoot(parents, p1), root2 = findRoot(parents, p2);
            
            if (root1 != root2) {    // Connect two sets of houses
                connect(parents, root1, root2);
                res += cost;
            }
        }
        
        return res;
    }
}