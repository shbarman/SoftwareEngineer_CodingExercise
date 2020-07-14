import java.util.Arrays;

public class nextPrem_31 {
    
    public static void main(String args[]){
        nextPrem_31 sol = new nextPrem_31();
        int[] nums = {1,1,5};
        sol.nextPermutation(nums); 
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        
        while(i>=0 && nums[i]>nums[i+1]){
            --i;
        }

        if(i==-1){
            reverse(nums,0,nums.length-1);
        }

        for(int j=nums.length-1;j>i;j--){
            if(nums[j]>nums[i]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums,i+1,nums.length-1);
    }

    public void reverse(int[] nums , int start , int end){
        while(start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end++] = temp;
        }
    }
}