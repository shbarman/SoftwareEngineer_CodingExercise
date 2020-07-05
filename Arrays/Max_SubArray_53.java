public class Max_SubArray_53{
    public int maxSubArray(int[] nums) {
    
        int start =0;
        int curr_Sum = nums[0];
        int max = curr_Sum;

        for(int end = start+1; end<nums.length;end++){
            int curr_val = nums[end];
            curr_Sum +=nums[end];

            if(curr_val>=curr_Sum){
                start = end;
                curr_Sum = curr_val;
            }
            max = Math.max(max,curr_Sum);
        }

    return max;
    }

    public static void main (String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Max_SubArray_53 sol = new Max_SubArray_53();
        System.out.println(sol.maxSubArray(nums));
    }
}