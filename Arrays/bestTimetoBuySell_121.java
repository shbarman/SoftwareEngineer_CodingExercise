public class bestTimetoBuySell_121{
    public static void main(String args[]){
        int[] price  = {7,1,5,3,6,4};
        bestTimetoBuySell_121 sol = new bestTimetoBuySell_121();
        System.out.println(sol.maxProfit(price));
    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            else if(prices[i]-minPrice>maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}