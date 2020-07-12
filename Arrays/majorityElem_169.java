import java.util.HashMap;

public class majorityElem_169 {
    
    public static void main(String args[]){
        majorityElem_169 sol = new majorityElem_169();
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        int result =0;
        int max =0;
        for(int i:map.keySet()){
            if(map.get(i)>nums.length/2 && map.get(i)>max ){
                max = map.get(i);
                result =i;
            }
        }
        return result;
    }
}