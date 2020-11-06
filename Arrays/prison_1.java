import java.util.*;


public class prison_1 {
    public static void main(String args[]){
        int [] nums = {14, 3, 1};
        int [] nums2 = {-4,3,1,14};
        System.out.println(solution(nums,nums2)); 
    }

    public static int solution(int[] x, int[] y){
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i: a){
        //     map.put(i,map.getOrDefault(i, 0)+1);
        // }
        // for(int i:b){
        //     map.put(i,map.getOrDefault(i, 0)+1);
        // }
        // //map.forEach((key, value) -> System.out.println(key + ":" + value));
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue()==1)
        //         return entry.getKey();
        // }
        // return -1;

            // Make the two lists
        //  Arrays.sort(x);
        //  Arrays.sort(y);
        //  for(int i=0;i<Math.min(x.length,y.length);i++){
        //      if(x[i]!=y[i]){
        //         return  x.length>y.length? x[i] :y[i];
        //      }
        //  }   
        //  return 0;
        
        // Set<Integer> setx =  Arrays.stream(x).boxed().collect(Collectors.toSet());
        // Set<Integer> sety =  Arrays.stream(y).boxed().collect(Collectors.toSet());
        
        // Set<Integer> intersection = new HashSet<Integer>(setx);
        // intersection.retainAll(sety);
        // Set<Integer> symmetricDifference = new HashSet<Integer>(setx);
        // symmetricDifference.addAll(sety);
        // symmetricDifference.removeAll(intersection);
        // List<Integer> list = new ArrayList<>(symmetricDifference);
        // return list.get(0);
        // int sum =0;
        // for(int i=0; i<Math.min(x.length,y.length);i++){
        //     sum +=
        // }

        // Set<Integer> union = Arrays.stream(x).boxed().collect(Collectors.toSet());
        // union.addAll(Arrays.stream(y).boxed().collect(Collectors.toSet()));

        // Set<Integer> intersection = Arrays.stream(x).boxed().collect(Collectors.toSet());
        // intersection.retainAll(Arrays.stream(y).boxed().collect(Collectors.toSet()));

        // union.removeAll(intersection);

        // return union.iterator().next();
        //char maxLen = x.length>y.length? 'x':'y';
        int sumX =0 , sumY=0, i=0;
        for(;i<Math.min(x.length,y.length);i++){
            sumX+=x[i];
            sumY +=y[i];
        }
        if(i==x.length)
            sumY+=y[i];
        else
            sumX+=x[i];
        return x.length>y.length? sumX-sumY : sumY-sumX;
    }
}
