package org.example.QuickFindQuickUnion;

// Weighted quick union..
public class QuickUnionImproved2UF {
    private int[] id;
    private int[] sz;

    public QuickUnionImproved2UF(int N) {
        for(int i = 0; i<N; i++)
        {
            id[i] = i;
            sz[i] = i;
        }

    }
    private int root(int i){
        while(i != id[i])
            id[i] = id[id[i]];
            i = id[i];
        return i;
    }
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if(sz[i] > sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
