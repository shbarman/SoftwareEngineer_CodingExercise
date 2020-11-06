public class MinPathSum24 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=1; i<n ;i++) grid[i][0]+=grid[i-1][0];
        for(int j=1; j<m ;j++) grid[0][j]+=grid[0][j-1];

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum24 min = new MinPathSum24();
        System.out.println(min.minPathSum(grid));
    }
}