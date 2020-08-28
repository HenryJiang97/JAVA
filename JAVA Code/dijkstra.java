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
    char vertex;
    int min_path = Integer.MAX_VALUE;    // Record the minimum path till current vertex
    vex parent = null;    // Record the parent vertex of current vertex
    boolean visited = false;
    vex (char vertex) {this.vertex = vertex;}
}

// Compare rule for priority queue (Increasing order of minimum path of vertex)
class my_comparator implements Comparator<vex> {
    public int compare(vex a, vex b) {
        return a.min_path - b.min_path;
    }
}


class dijkstra {
    public static void main(String[] args) {
        ///////////////////////////////////////////////////////////////////
        // Build graph
        // Create vexes
        vex A = new vex('A');
        vex B = new vex('B');
        vex C = new vex('C');
        vex D = new vex('D');
        vex E = new vex('E');
        vex F = new vex('F');
        vex G = new vex('G');
        vex H = new vex('H');


        // Set up edge information
        // Edge information (A)
        List<weightedEdge> edgeA = new ArrayList<>();
        edgeA.add(new weightedEdge(C, 7));
        edgeA.add(new weightedEdge(D, 6));    
        edgeA.add(new weightedEdge(B, 1));
        // Edge information (B)
        List<weightedEdge> edgeB = new ArrayList<>();
        edgeB.add(new weightedEdge(A, 1));
        edgeB.add(new weightedEdge(D, 4));
        // Edge information (C)
        List<weightedEdge> edgeC = new ArrayList<>();
        edgeC.add(new weightedEdge(A, 7));
        edgeC.add(new weightedEdge(D, 8));
        edgeC.add(new weightedEdge(E, 3));
        edgeC.add(new weightedEdge(F, 12));
        // Edge information (D)
        List<weightedEdge> edgeD = new ArrayList<>();
        edgeD.add(new weightedEdge(B, 4));
        edgeD.add(new weightedEdge(A, 6));
        edgeD.add(new weightedEdge(C, 8));
        edgeD.add(new weightedEdge(F, 13));
        // Edge information (E)
        List<weightedEdge> edgeE = new ArrayList<>();
        edgeE.add(new weightedEdge(C, 3));
        edgeE.add(new weightedEdge(F, 5));
        edgeE.add(new weightedEdge(G, 11));
        // Edge information (F)
        List<weightedEdge> edgeF = new ArrayList<>();
        edgeF.add(new weightedEdge(D, 13));
        edgeF.add(new weightedEdge(C, 12));
        edgeF.add(new weightedEdge(E, 5));
        edgeF.add(new weightedEdge(G, 10));
        edgeF.add(new weightedEdge(H, 2));
        // Edge information (G)
        List<weightedEdge> edgeG = new ArrayList<>();
        edgeG.add(new weightedEdge(E, 11));
        edgeG.add(new weightedEdge(F, 10));
        edgeG.add(new weightedEdge(H, 9));
        // Edge information (H)
        List<weightedEdge> edgeH = new ArrayList<>();
        edgeH.add(new weightedEdge(F, 2));
        edgeH.add(new weightedEdge(G, 9));


        // Set up and init the graph
        Map<Character, List<weightedEdge>> graph = new HashMap<>();
        graph.put('A', edgeA);
        graph.put('B', edgeB);
        graph.put('C', edgeC);
        graph.put('D', edgeD);
        graph.put('E', edgeE);
        graph.put('F', edgeF);
        graph.put('G', edgeG);
        graph.put('H', edgeH);

        ///////////////////////////////////////////////////////////////////

        dijkstra obj = new dijkstra();


        vex start = A, des = H;
        start.min_path = 0;
        obj.shortest_path(graph, start);

        
        ///////////////////////////////////////////////////////////////////        
        // Get the result using backtracking

        // System.out.println(A.min_path);
        // System.out.println(B.min_path);
        // System.out.println(C.min_path);
        // System.out.println(D.min_path);
        // System.out.println(E.min_path);
        // System.out.println(F.min_path);
        // System.out.println(G.min_path);
        // System.out.println(H.min_path);

        List<Character> res = new ArrayList<>();
        vex current_vex = des;
        while (current_vex != null) {
            res.add(current_vex.vertex);
            current_vex = current_vex.parent;
        }

        Collections.reverse(res);
        System.out.println(res);
    }


    public void shortest_path(Map<Character, List<weightedEdge>> graph, vex start) {
        // Init priority queue
        PriorityQueue<vex> pq = new PriorityQueue<>(new my_comparator());       
        pq.offer(start);

        while (!pq.isEmpty()) {
            vex out = pq.poll();

            for (weightedEdge edge : graph.get(out.vertex)) {
                if (edge.vertex.visited)    continue;
                
                // Update the minimum path and parents of the vex at the end of the edge if necessary
                if (edge.vertex.min_path > out.min_path + edge.weight) {
                    edge.vertex.min_path = out.min_path + edge.weight;
                    edge.vertex.parent = out;

                    // If the min_path of the edge has updated, remove it from pq first
                    if (pq.contains(edge.vertex)) {
                        pq.remove(edge.vertex);
                    }
                }
                
                // Add the edge to priority queue
                if (!pq.contains(edge.vertex))
                    pq.offer(edge.vertex);
            }
            
            out.visited = true;    // When all edges of the vex are visited, mark the vex as visited
        }
    }
}