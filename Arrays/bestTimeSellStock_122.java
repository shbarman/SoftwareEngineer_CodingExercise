public class bestTimeSellStock_122 {
    public static void main(String args[]){
        bestTimeSellStock_122 sol = new bestTimeSellStock_122();
        int arr[] = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(arr));
    }
    public int maxProfit(int[] prices){
        int maxProfit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}