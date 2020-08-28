public class SegTree {
    int start, end;
    SegTree left = null, right = null;
    boolean status;
    public SegTree(int start, int end, boolean status) {
        this.start = start;    this.end = end;    this.status = status;
    }
  
    public void setStatus(int a, int b, boolean s) {
        if (a <= start && b >= end) {    // All children of node[start, end] are unnecessary, remove them
            left = null;    right = null;
            status = s;
            return;
        }
        if (b <= start || a >= end)    return;    // Not the responsibility of current node
            
        int mid = start + (end - start) / 2;
        if (left == null) {    // Reaches the leaf node of the tree, create its children
            left = new SegTree(start, mid, status);
            right = new SegTree(mid, end, status);
        }
            
        // Recurrsion
        left.setStatus(a, b, s);
        right.setStatus(a, b, s);
        status = left.status && right.status;
    }
        
    public boolean getStatus(int a, int b) {
        if (a <= start && b >= end)    return status;    // Within the range of [start, end]
        if (b <= start || a >= end)    return true;    // Out of the range, not the responsibility of [start, end]
  
        if (left == null)    return status;    // Reach the leaf node of the tree
            
        // Recurrsion
        return left.getStatus(a, b) && right.getStatus(a, b);
    }
}