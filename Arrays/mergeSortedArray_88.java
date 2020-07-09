import java.util.Arrays;

public class mergeSortedArray_88 {
    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n=3;
        mergeSortedArray_88 sol = new mergeSortedArray_88();
        System.out.println(Arrays.toString(sol.merge(nums1, m, nums2, n)));

    }
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while((p1>=0)&&(p2>=0)){
           nums1[p--] = nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--];
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
        return nums1;

        
    }
}