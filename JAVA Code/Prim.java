import java.util.*;


// Define the data structure for edge in the graph
class Edge {
    char start;
    char end;
    int weight;
    Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

// Define the data structure for edges from one point with weight in the weighted graph
class weightedEdge {
    char vertex;
    int weight;
    weightedEdge(char vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Comparator interface for implementing Priority Queue
class my_comparator implements Comparator<Edge>{
    public int compare(Edge a, Edge b) {
        if (a.weight > b.weight)    return 1;
        else    return -1;
    }
}



class prim {
    public HashMap<Character, List<weightedEdge>> buildGraph() {
        // Set up edge information
        // Edge information (A)
        List<weightedEdge> edgeA = new ArrayList<>();
        edgeA.add(new weightedEdge('C', 7));
        edgeA.add(new weightedEdge('D', 6));    
        edgeA.add(new weightedEdge('B', 1));
        // Edge information (B)
        List<weightedEdge> edgeB = new ArrayList<>();
        edgeB.add(new weightedEdge('A', 1));
        edgeB.add(new weightedEdge('D', 4));
        // Edge information (C)
        List<weightedEdge> edgeC = new ArrayList<>();
        edgeC.add(new weightedEdge('A', 7));
        edgeC.add(new weightedEdge('D', 8));
        edgeC.add(new weightedEdge('E', 3));
        edgeC.add(new weightedEdge('F', 12));
        // Edge information (D)
        List<weightedEdge> edgeD = new ArrayList<>();
        edgeD.add(new weightedEdge('B', 4));
        edgeD.add(new weightedEdge('A', 6));
        edgeD.add(new weightedEdge('C', 8));
        edgeD.add(new weightedEdge('F', 13));
        // Edge information (E)
        List<weightedEdge> edgeE = new ArrayList<>();
        edgeE.add(new weightedEdge('C', 3));
        edgeE.add(new weightedEdge('F', 5));
        edgeE.add(new weightedEdge('G', 11));
        // Edge information (F)
        List<weightedEdge> edgeF = new ArrayList<>();
        edgeF.add(new weightedEdge('D', 13));
        edgeF.add(new weightedEdge('C', 12));
        edgeF.add(new weightedEdge('E', 5));
        edgeF.add(new weightedEdge('G', 10));
        edgeF.add(new weightedEdge('H', 2));
        // Edge information (G)
        List<weightedEdge> edgeG = new ArrayList<>();
        edgeG.add(new weightedEdge('E', 11));
        edgeG.add(new weightedEdge('F', 10));
        edgeG.add(new weightedEdge('H', 9));
        // Edge information (H)
        List<weightedEdge> edgeH = new ArrayList<>();
        edgeH.add(new weightedEdge('F', 2));
        edgeH.add(new weightedEdge('G', 9));


        // Set up and init the graph
        HashMap<Character, List<weightedEdge>> graph = new HashMap<>();
        graph.put('A', edgeA);
        graph.put('B', edgeB);
        graph.put('C', edgeC);
        graph.put('D', edgeD);
        graph.put('E', edgeE);
        graph.put('F', edgeF);
        graph.put('G', edgeG);
        graph.put('H', edgeH);


        return graph;
    }

    public List<List<Character>> mst(HashMap<Character, List<weightedEdge>> graph) {
        List<List<Character>> res = new ArrayList<>();
        
        // Init Priority Queue and visitedVEX list
        PriorityQueue<Edge> pq = new PriorityQueue<>(new my_comparator());
        List<Character> visitedVEX = new ArrayList<>();

        // Starter Vex (A)
        char first = 'A';
        for (weightedEdge edge : graph.get(first))    pq.offer(new Edge(first, edge.vertex, edge.weight));
        visitedVEX.add(first);

        while (!pq.isEmpty()) {
            // Delete redundant edges in the Priority Queue
            while (pq.size() > 0 && visitedVEX.contains(pq.peek().end))    pq.poll();
            if (pq.isEmpty())    break;

            Edge out = pq.poll();    // Get the edge with minimum weight from pq

            visitedVEX.add(out.end);    // Add the visited node to visitedVEX list
            
            // For every edge out from the vertex, add them to the Priority Queue
            for (weightedEdge edge : graph.get(out.end)) {
                if (!visitedVEX.contains(edge.vertex))
                    pq.offer(new Edge(out.end, edge.vertex, edge.weight));
            }
            
            // Save the edge to list
            res.add(new ArrayList<Character>(Arrays.asList(out.start, out.end)));
        }

        
        return res;
    }

    

    public static void main(String[] args) {
        prim mc = new prim();

        // Build and init graph
        HashMap<Character, List<weightedEdge>> graph = mc.buildGraph();

        // Do Prim Algorithms to find MST
        List<List<Character>> result = mc.mst(graph);

        System.out.println(result);
    }
}