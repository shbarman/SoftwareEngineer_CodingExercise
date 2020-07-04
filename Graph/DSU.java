public class DSU {
    int[] parent;

    public DSU(int N){
        parent = new int[N];
        for(int i=0; i<N;i++){
            parent[i] = i;
        }
    }

    public boolean union(int a, int b){
        int A = find(a) , B = find(b);
        if(A==B){
            return false;
        }
        else
        parent[A] = B;
        return true;

    }

    public int find(int r){
        if(parent[r]!=r) parent[r]= find(parent[r]);
        return parent[r];
    }

    public boolean connected(int a , int b){
        return find(a)==find(b);
    }
}