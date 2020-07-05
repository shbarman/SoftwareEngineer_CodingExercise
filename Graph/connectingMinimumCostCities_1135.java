import java.util.*;

public class connectingMinimumCostCities_1135 {
    
    public int minimumCost(int N, int[][] connections) {
        DSU dsu = new DSU(N+1);
        Arrays.sort(connections,(a,b)-> a[2]-b[2]);
        int cost = 0,component=N;
        for(int[] conn: connections){
            if(dsu.union(conn[0], conn[1])){
                cost+=conn[2];
                component--;
            }
        }
        return component==1?cost:-1;
    }
    public static void main(String args[]){
        connectingMinimumCostCities_1135 sol = new connectingMinimumCostCities_1135();
        int[][] graph={{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(sol.minimumCost(3, graph));
    }   
 }