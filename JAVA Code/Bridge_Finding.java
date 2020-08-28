// Bridge-finding

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> connection : connections) {
            List<Integer> next1 = map.getOrDefault(connection.get(0), new ArrayList<Integer>());
            next1.add(connection.get(1));
            map.put(connection.get(0), next1);
            
            List<Integer> next2 = map.getOrDefault(connection.get(1), new ArrayList<Integer>());
            next2.add(connection.get(0));
            map.put(connection.get(1), next2);
        }
        
        // Run bridge-finding algorithms
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        class Solution {
            public int longestRepeatingSubstring(String S) {
                int n = S.length();
                int[][] dp = new int[n][n];
                int max = 0;
                // Init
                for (int j = 1; j < n; j++)
                    if (S.charAt(j) == S.charAt(0)) {
                        dp[0][j] = 1;
                        max = 1;
                    }
                // Build
                for (int i = 1; i < n; i++)
                    for (int j = i + 1; j < n; j++)
                        if (S.charAt(i) == S.charAt(j)) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                            max = Math.max(max, dp[i][j]);
                        }
                return max;
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i])    continue;    // Can delete if the graph is connected
            dfs(map, visited, parent, disc, low, i, res);
        }
        
        return res;
    }
    
    private int time = 0;
    
    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int[] parent, int[] disc, int[] low, int u, List<List<Integer>> res) {
        disc[u] = time;    low[u] = time;    time++;
        visited[u] = true;
        if (!map.containsKey(u))    return;
        
        for (int v : map.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                dfs(map, visited, parent, disc, low, v, res);
                
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(new ArrayList<Integer>(Arrays.asList(u, v)));
                }
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}