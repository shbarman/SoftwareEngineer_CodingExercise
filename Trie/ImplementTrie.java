import java.util.*;
class Node{
    Node[] links;
    int times=0;
    boolean isEnd = false;
    Node(){
        links = new Node[27];
    }
    public void addLink(char ch){
        links[ch-'a'] = new Node();
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public boolean isEnd(){
        return isEnd;
    }
    public void setEnd(int times){
        this.times = times;
        isEnd = true;
    }
    public int getTimes(char ch){
        return links[ch-'a'].times;
    }
}

class Trie{
    Node root;

    Trie(){
        root = new Node();

    }
    public void insert(String word, int times){
        Node node = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch-'a';
            if(node.links[index]==null){
               node.addLink(ch);
            }
            node = node.get(ch);
        }
        node.setEnd(times);
    }

    pubic List<Node> lookup(Trie t, String s){
        List<Node> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(t.root.links[s.charAt(i)-'a'] == null){
                return new ArrayList<>();
            }
            t = t.root.links[s.charAt(i)-'a'];
            
        }
        find(t,s,result);
        return result;    
        }

}



public class ImplementTrie{







}