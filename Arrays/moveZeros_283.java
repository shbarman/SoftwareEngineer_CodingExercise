import java.util.Arrays;

public class moveZeros_283 {
    public static void main(String args[]){
        int [] nums = {0,1,0,3,12};
        moveZeros_283 sol = new moveZeros_283();
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        for(int i=0, lastCheck=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,lastCheck++,i);
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}