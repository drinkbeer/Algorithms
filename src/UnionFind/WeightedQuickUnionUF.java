package UnionFind;

/**
 * Created by chen on 15/1/26.
 */
public class WeightedQuickUnionUF {
    private int[] id;       //parent link
    private int[] sz;       //size of component for roots
    private int count;      //number of components

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //find root
    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public int[] getId() {
        return id;
    }
}
