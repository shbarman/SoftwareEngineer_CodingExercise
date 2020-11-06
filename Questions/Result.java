public class Solution {
    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER startRow
     *  3. INTEGER startCol
     *  4. INTEGER endRow
     *  5. INTEGER endCol
     *  6. INTEGER bishopRow
     *  7. INTEGER bishopCol
     */
    
    
    static class cell{
        int x,y,dis;
        public cell(int x, int y, int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    
    static boolean isInsideBoard(int x, int y, int n){
        if(x>=0 && x<n && y>=0 && y<n){
            return true;
        }
        return false;
    }
    public static int moves(int n, int startRow, int startCol, int endRow, int endCol, int bishopRow, int bishopCol) {
        int[] dx=  {-2,-1,1,2,-2,-1,1,2};
        int[] dy=  {-1,-2,-2,-1,1,2,2,1};
        boolean[][] bishopmove = new boolean[n][n];
        findPosBishop(bishopRow,bishopCol,bishopmove,n);
        boolean[][] matrix = new boolean[n+1][n+1];
        Queue<cell> queue = new LinkedList<>();
        queue.add(new cell(startRow,startCol,0));
        
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n;j++){
                matrix[i][j]=false;
            }
        }
        cell t;
        int x,y;
        matrix[startRow][startCol]=true;
        boolean bishopFound= false;
        while(!queue.isEmpty()){
            t=queue.poll();
            if(t.x == endRow && t.y==endCol){
                return t.dis;
            }
            for(int i=0; i<8; i++){
                x = t.x+dx[i];
                y= t.y+dy[i];
                
                if(isInsideBoard(x,y,n) && !matrix[x][y]){
                    if(bishopRow==x && bishopRow==y){
                        bishopFound=true;
                    }
                    if(!bishopFound){
                        if(!bishopmove[x][y]){
                        matrix[x][y]=true;
                        queue.add(new cell(x,y,t.dis+1));
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
        
    }
    
    public static void findPosBishop(int bishopRow,int bishopCol,boolean[][] bishopmove ,int n){
        int[] dx={-1,1,1,-1};
        int[] dy={-1,-1,1,1};
            
            for(int k=0; k<4;k++){
                int newX= bishopRow;
                int newY = bishopCol;
                while(isInsideBoard(newX,newY,n)){
                    bishopmove[newX][newY]=true;
                    newX+=dx[k];
                    newY+=dy[k];
                }
            }
            
    }

}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int startRow = Integer.parseInt(bufferedReader.readLine().trim());

        int startCol = Integer.parseInt(bufferedReader.readLine().trim());

        int endRow = Integer.parseInt(bufferedReader.readLine().trim());

        int endCol = Integer.parseInt(bufferedReader.readLine().trim());

        int bishopRow = Integer.parseInt(bufferedReader.readLine().trim());

        int bishopCol = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.moves(n, startRow, startCol, endRow, endCol, bishopRow, bishopCol);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


}
