import java.util.Arrays;
import java.util.HashMap;

public class subarraySumEqK_560 {
    
    public static void main(String args[]){
        subarraySumEqK_560 sol = new subarraySumEqK_560();
        int[] nums ={1,1,1};
        int k =2;
        System.out.println(sol.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0,sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}