//import java.util.Stack;

//No of connected components hence union find
class friend_Circles_547 {

    public static void main(String args[]){
        int[][] graph = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        friend_Circles_547 solution = new friend_Circles_547();
        System.out.println(solution.findCircleNum(graph));
        System.out.println(solution.dfsSolve(graph));

    }
    
    public int findCircleNum(int[][] M){
      int [] parent = new int[M.length];
      for (int i = 0; i < M.length; ++i)
            parent[i] = i;
      for(int i=0;i<M.length;i++){
          for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1 && i!=j)
                union(parent,i,j);
          }
      }
      
      int frnds =0;
      for(int i=0;i<M.length;i++){
        if(find(parent,i)==i) frnds++;
        }
        return frnds;
    }
    
    void union(int[] parent,int i, int j){
        int A = find(parent,i);
        int B = find(parent,j);

        if(A!=B){
            parent[A] =B;
        }
    }

   int find(int[] parent,int i){
       if(parent[i]==i) parent[i] = find(parent,parent[i]);

       return parent[i];
   }

   public int dfsSolve(int[][] M){
    int N = M.length;
    int[] visited = new int[N];
    int count=0;
    for(int i=0; i<N;i++){
        if(visited[i]==0){
            dfs(visited,i,M);
            count++;
        }
    }
    return count;
   }

   void dfs(int[] visited, int i, int[][] M){
       for(int j=0; j<M.length;j++){
           if(visited[j]==0 && M[i][j]==1){
               visited[j]=1;
               dfs(visited,j,M);
               
           }
       }
   }
}

