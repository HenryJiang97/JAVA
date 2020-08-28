private int find(int[] root, int p) {
    if (root[p] != p)
        root[p] = find(root, root[p]);
    return root[p];


private void union(int[] root, int n1, int n2) {
    int r1 = find(root, n1), r2 = find(root, n2);
    if (r1 < r2)    root[r2] = r1;
    else    root[r1] = r2;
}}