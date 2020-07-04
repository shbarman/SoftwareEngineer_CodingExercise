import java.util.HashSet;

public class mostStonesRemovedWithSameRowOrColumn_947{
    int MAX_VAL = 20000;
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(MAX_VAL);
        int N = stones.length;
        for(int[] stone:stones){
            dsu.union(stone[0], stone[1]+10000);
        }

        HashSet<Integer> seen = new HashSet<>();
        for(int[] stone:stones){
            seen.add(dsu.find(stone[0]));
        }

        return N - seen.size();
    }

    public static void main(String args[]){
        int[][] graph = {{0,0},{0,1,},{1,0},{1,2},{2,1},{2,2}};
        mostStonesRemovedWithSameRowOrColumn_947 solution = new mostStonesRemovedWithSameRowOrColumn_947();
        System.out.println(solution.removeStones(graph));

    }
}