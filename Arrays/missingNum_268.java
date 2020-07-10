import java.util.*;
public class missingNum_268 {

    public static void main(String args[]){
        missingNum_268 sol = new missingNum_268();
        int[] nums = {2,0,3,4,5,1,7};
        System.out.println(sol.missingNumber(nums));
    }
    public int missingNumber(int[] nums){
        //O(1) space and O(nlgn) time complexity
        // Arrays.sort(nums);

        // if(nums[nums.length-1]!=nums.length)
        //     return nums.length;
        // else if(nums[0]!=0)
        //     return 0;
        // for(int i=1; i<nums.length+1;i++){
        //     if(nums[i]!=nums[i-1]+1)
        //         return i;
        // }
        // return -1;  
        
        //Approach 2 with O(n) space and time complexity

        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);

        for(int i=0; i<nums.length ; i++){
          if(!set.contains(i))
            return i;  
        }
        return -1;
    } 
}