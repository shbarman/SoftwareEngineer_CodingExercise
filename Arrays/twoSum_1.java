import java.util.Arrays;
import java.util.HashMap;

class twoSum_1 {
    public int[] twoSum(int[] nums, int target) { 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        throw new AssertionError();
    }

    public static void main(String args[]){
        twoSum_1 sol = new twoSum_1();
        int[] nums = {2, 7, 11, 15};
        int target =9;
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }
}