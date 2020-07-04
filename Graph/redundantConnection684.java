//import java.util.ArrayList;
import java.util.Arrays;

public class redundantConnection684 {
    public static void main(String args[]){
        int[][] graph = {{1,2},{1,3},{2,3}};
        redundantConnection684 solution = new redundantConnection684();
        int[] print = solution.findRedundantConnection(graph);
        System.out.println(Arrays.toString(print));
    }
     int MAX_EDGE = 1000;
    public  int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE+1);
        for(int[] edge: edges){
            if(!dsu.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
    }


    // public int[] dsfSolve(int[][] edges){
    //     ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE+1];
    //     for(int i=0 ; i< MAX_EDGE ; i++){
    //         graph[i] = new ArrayList();
    //     }

    //     for(int []edge : edges){
            
    //     }
    // }

}

