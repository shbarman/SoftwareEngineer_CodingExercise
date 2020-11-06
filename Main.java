      /* Problem Name is &&& Longest Word &&& PLEASE DO NOT REMOVE THIS LINE. */

      /**
       * Instructions to candidate.
       *  1) Given a a string of letters and a dictionary, the function longestWord should
       *     find the longest word or words in the dictionary that can be made from the letters
       *     Input: letters = "oet", dictionary = {"to","toe","toes"}
       *     Output: {"toe"}
       *     Only lowercase letters will occur in the dictionary and the letters
       *     The length of letters will be between 1 and 10 characters
       *     The solution should work well for a dictionary of over 100,000 words
       *  2) Run this code in the REPL to observe its behaviour. The
       *     execution entry point is main().
       *  3) Consider adding some additional tests in doTestsPass().
       *  4) Implement the longestWord() method correctly.
       *  5) If time permits, introduce '?' which can represent any letter.  "to?" could match to "toe", "ton" etc
       */

      import java.util.*;

      class Dictionary {
        private String[] entries;

        public Dictionary(String[] entries) {
          this.entries = entries;
        }
        public List<String> getStringDictionary(){
          return Arrays.asList(this.entries);
        }
        public boolean contains(String word) {
          return Arrays.asList(entries).contains(word);
        }
      }

      public class Solution {
        public static Set<String> longestWord(String letters, Dictionary dict) {

          Set<String> result = new HashSet<String>();

          HashMap<String,List<String>> map = new HashMap<>();

          for(String str: dict.getStringDictionary())
          {
            char[] word= str.toCharArray();
            Arrays.sort(word);
            String key = new String(word);

            if(!map.containsKey(key))
            {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(key,strList);
              }

            else

            {
               List<String> strList = map.get(key);
                strList.add(str);
                map.put(key,strList);
            }

          }

          char[] letterChars = letters.toCharArray();
          Arrays.sort(letterChars);

          String check = new String(letterChars);

          if(map.containsKey(check))
          {
                for(String s:map.get(check))
                {
                    result.add(s);
                }

          } 
         else
          {
          String ansValue= new String();
          Set<String> ansValues = new HashSet<>();
          for(Map.Entry<String,List<String>> entry: map.entrySet()){
            String key = entry.getKey();

            if(permute(check,key)){
              if(key.length()>=ansValue.length()){
                ansValue = new String(key);
              }
            }

            ansValues.add(ansValue);
          }

           for(String s:ansValues ){
             
             if(map.containsKey(s)){
               
                for(String str:map.get(s)){
                    result.add(str);
                }

              } 
           }

        }
          System.out.println(result);

          return result;
        }

        public static boolean permute(String check, String key){

                List<String> word = new ArrayList<>();
                findCombinationString(check,0,word, new StringBuilder());
                for(String str: word){
                  if(str.equals(key)){
                  return true;
                  }
                }
              return false;  
        }

        public static void findCombinationString(String word, int pos, List<String> words, StringBuilder s){
            for(int i=pos;i<word.length();i++){
              s.append(word.charAt(i));
              words.add(new String(s));
              if(i<word.length())
                findCombinationString(word,i+1,words,s);
              s.setLength(s.length()-1);
          }

        }

        //degtos

        public static boolean doTestsPass() {
          Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});

          boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
          result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));

          return result;
        }

        /**
         * Execution entry point.
         */
        public static void main(String[] args) {
          if(doTestsPass()) {
            System.out.println("All tests pass");
          } else {
            System.err.println("There are test failures");
          }
        }
      }