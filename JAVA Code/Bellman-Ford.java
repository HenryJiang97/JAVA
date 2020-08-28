import java.io.*;
import java.util.*;

// Data type for each weighted edge
class weightedEdge {
    vex vertex;    // The end vertex of the weighted edge
    int weight;
    weightedEdge(vex vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Data type for each vertex
class vex {
    int vertex;
    vex (int vertex) {this.vertex = vertex;}
}

// Data type to save the result in dp array
class res {
    int max_path = Integer.MIN_VALUE;
    vex successer = null;
}


class Main {
    private static int vexNum;

    private void longest_path(Map<Integer, List<weightedEdge>> graph, vex start, res[][] dp) {
        // Init the dp array
        for (int i = 0; i < vexNum; i++)    dp[0][i] = new res();
        dp[0][0].max_path = 0;

        // Build the dp array
        for (int i = 1; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                dp[i][j] = dp[i - 1][j];    // The choice to have less than i edge to the destination
                if (!graph.containsKey(j))    continue;
                for (weightedEdge edge : graph.get(j)) {
                    if (dp[i - 1][edge.vertex.vertex].max_path == Integer.MIN_VALUE)    continue;

                    // Update dp[i][j] since its value is greater than dp[i - 1][j]
                    if (dp[i][j].max_path < dp[i - 1][edge.vertex.vertex].max_path + edge.weight)
                        dp[i][j].successer = edge.vertex;
                    dp[i][j].max_path = Math.max(dp[i][j].max_path, dp[i - 1][edge.vertex.vertex].max_path + edge.weight);
                }
            }
        }
    }


    public static void main(String[] args) {
        Main obj = new Main();
        //////////////////////////////////////////////////////////////////////////
        // Do Bellman-Ford algorithms to find the shortest path from 0 to i

        obj.longest_path(edge, start, dp);
        
}