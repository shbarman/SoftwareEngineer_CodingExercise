public class numberOfConnections_1319{
    public int makeConnected(int n, int[][] connections) {
        if (connections.length<n-1) return -1;
        //int N = connections.length;
        DSU dsu = new DSU(n);
        for(int[] connect: connections){
            dsu.union(connect[0], connect[1]);
        }
        int numConnected =0;
        for(int i=0; i<n;i++){
            if(i==dsu.parent[i]) numConnected++;
        }
        return numConnected-1;
    }

    public static void main(String args[]){
        int[][] graph = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        numberOfConnections_1319 num = new numberOfConnections_1319();
        
        System.out.println(num.makeConnected(6, graph));
    }
}