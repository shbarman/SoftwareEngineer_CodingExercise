import java.util.Collections;
import java.util.List;
import java.util.*;

class Node{
    String sentence;
    int times;
    Node(final String sentence, final int times) {
        this.sentence = sentence;
        this.times = times;
    }
}

class Trie {
    Trie[] branches = new Trie[27];
    int times;
}

public class autocomplete {
    Trie root;
    String curr_sent = "";

    autocomplete(final String[] sentences, final int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    public int toInt(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }

    public void insert(Trie t, String sentence, int times) {
        for (int i = 0; i < sentence.length(); i++) {
            if (t.branches[toInt(sentence.charAt(i))] == null) {
                t.branches[toInt(sentence.charAt(i))] = new Trie();
            }
            t = t.branches[toInt(sentence.charAt(i))];
        }
        t.times += times;
    }

    public List<Node> lookup(Trie t,  String sentence) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (t.branches[toInt(sentence.charAt(i))] == null) {
                return new ArrayList<>();
            }
            t = t.branches[toInt(sentence.charAt(i))];
        }
        traverse(t, sentence, list);
        return list;
    }

    public void traverse(Trie t, String sentence, List<Node> list){
        if(t.times>0) list.add(new Node(sentence,t.times));
        for(char c='a';c<='z';c++){
            if(t.branches[c-'a']!=null){
                traverse(t.branches[c-'a'],sentence+c,list);
            }
        }    
            if(t.branches[26]!=null){
                traverse(t.branches[26],sentence+' ',list);
            } 
    }

    public List<String> input(final char c) {
        final List<String> result = new ArrayList<>();
        if (c == '#') {
            insert(root, curr_sent, 1);
            curr_sent = "";
        } else {
            curr_sent += c;
            final List<Node> list = lookup(root, curr_sent);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);

            for (int i = 0; i < Math.min(3, list.size()); i++) {
                result.add(list.get(i).sentence);
            }
        }
        return result;
    }

    public static void main(final String[] args) {
        final String[] sentences = { "i love you", "island", "iroman", "i love leetcode" };
        final int[] times = { 5, 3, 2, 2 };
        final autocomplete auto = new autocomplete(sentences, times);
        System.out.println(auto.input('i').toString());
    }
}