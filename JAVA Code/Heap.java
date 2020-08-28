PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

pq.add(0);

pq.remove();

pq.peek();

pq.poll();

pq.isEmpty();

pq.size();

// Custom comparator
PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return a[2] - b[2];
    }
});