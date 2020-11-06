import java.io.InputStream;
import java.util.Scanner;
import java.util.*;
public class try1 {
    public static void main(String args[]) {
        // To read from stdin:
        InputStream source = System.in;
 
        /*
        Or, to read from a file:
        InputStream source = new FileInputStream(filename);
 
        Or, to read from a network stream:
        InputStream source = socket.getInputStream();
        */
 
        Scanner scanner = new Scanner(System.in);
        try1 min = new try1();
        List<String> tokens = new ArrayList<>();
		while (scanner.hasNext()) {
            //List<String> tokens = Arrays.asList(scanner.nextLine().split("\\s"));
        String str = scanner.next();
           tokens.add(str);
           scanner.close();
        }
        
        min.countFreq(tokens);
	//System.out.println(tokens);
        
        
        
        
    }

    public void countFreq(List<String> words){
        HashMap<String, Integer> mapCount = new HashMap<>();
        for(String s: words){
            mapCount.put(s,mapCount.getOrDefault(s, 0)+1);
        }
        ArrayList<String> sortedKeys = new ArrayList<>(mapCount.keySet());
        Collections.sort(sortedKeys);
        for(String str: sortedKeys){
            System.out.println(str +" "+ mapCount.get(str));
        }


    }



}