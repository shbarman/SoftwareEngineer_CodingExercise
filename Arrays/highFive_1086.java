import java.util.*;

public class highFive_1086 {

    public static void main(String args[]){
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive_1086 sol = new highFive_1086();
        System.out.println(Arrays.deepToString(sol.highFive(items)));
    }

    public int[][] highFive(int[][] items) {
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i:items){
            if(map.containsKey(i[0])){
                List<Integer> list = map.get(i[0]);
                list.add(i[1]);
                map.put(i[0],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i[1]);
                map.put(i[0],list);
            }
        }

        int[][] result = new int[map.size()][2];
        int k=0;
        for(int i:map.keySet()){
            List<Integer> list = map.get(i);
            Collections.sort(list,(a,b)->b-a);
            int sum =0;
            for(int j=0;j<list.size() && j<5 ;j++){
                sum+=list.get(j);
            }
            int avg = list.size()<5? sum/list.size() : sum/5 ;
            result[k][0] = i;
            result[k++][1] = avg;
        }
        return result;
    }

}