class MinCost_746 {
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] =cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String args[]){
        //746_MinCost min = new 746_MinCost();
        int[] cost= {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}