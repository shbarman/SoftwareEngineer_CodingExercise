

class TrieNode{
    private TrieNode[] branches;
    private boolean isEnd;
    TrieNode(){
        branches= new TrieNode[26];
        isEnd = false;
    }
    public boolean containsKey(char ch){
        return branches[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return branches[ch-'a'];
    }
    public void set(char ch,TrieNode node ){
        branches[ch-'a'] = node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    } 
}

public class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String word) {  
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.set(ch, node);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node.isEnd() && node!=null;
    }
    
    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else
            return null;
        }
        return node;
    }

    public boolean startsWith(String word){
        TrieNode node = searchPrefix(word);

        return node!=null;
    }
}