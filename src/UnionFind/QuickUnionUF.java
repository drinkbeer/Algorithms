package UnionFind;

/**
 * Created by chen on 15/1/26.
 */
public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
    }
}
