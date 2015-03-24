package UnionFind;

/**
 * Created by chen on 15/1/26.
 */
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
    }

    public int[] getId() {
        return id;
    }
}
