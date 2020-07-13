import java.util.Arrays;

public class prodArraySelf_238 {
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        prodArraySelf_238 sol = new prodArraySelf_238();

        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];

        ans[0]=1;
        for(int i = 1 ; i<length;i++){
            ans[i]= ans[i-1]*nums[i-1];
        }

        int R = 1;

        for(int i=length-1; i>=0; i--){
            ans[i] = ans[i]*R;
            R*=nums[i];
        }
        return ans;
    }
}