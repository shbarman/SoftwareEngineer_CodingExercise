import java.util.*;
public class Main {
    public static void main( String[] args) {
         String[] words = { "i love you", "island", "ironman", "i love leetcode" };
         int[] score = { 1, 3, 2, 2 };
         AutocompleteSystem obj = new AutocompleteSystem(words, score);
         List<String> param_1 = obj.input('i');
        System.out.println(param_1);
    }
}

class TrieN {
    String sentence;
    int score;

    TrieN( String sentence, int score) {
        this.sentence = sentence;
        this.score = score;
    }
}

class Tries {
    Tries[] branches = new Tries[27];
    int score;
}

class AutocompleteSystem {
    Tries root;
    String curr_sent = "";

    public AutocompleteSystem( String[] sentences,  int[] score) {
        root = new Tries();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], score[i]);
        }
    }

    public int toInt( char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }

    public void insert(Tries t,  String sentence,  int score) {
        for (int i = 0; i < sentence.length(); i++) {
            if (t.branches[toInt(sentence.charAt(i))] == null) {
                t.branches[toInt(sentence.charAt(i))] = new Tries();
            }
            t = t.branches[toInt(sentence.charAt(i))];
        }
        t.score += score;
    }

    public List<TrieN> lookup(Tries t,  String s) {
        final List<TrieN> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[toInt(s.charAt(i))] == null) {
                return new ArrayList<>();
            }
            t = t.branches[toInt(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }

    public void traverse( String s,  Tries t,  List<TrieN> list) {
        if (t.score > 0)
            list.add(new TrieN(s, t.score));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null) {
                traverse(s + i, t.branches[i - 'a'], list);
            }
        }
        if (t.branches[26] != null) {
            traverse(s + ' ', t.branches[26], list);
        }

    }

    public List<String> input( char c) {
        final List<String> result = new ArrayList<>();
        if (c == '#') {
            insert(root, curr_sent, 1);
            curr_sent = "";
        } else {
            curr_sent += c;
            final List<TrieN> list = lookup(root, curr_sent);
            Collections.sort(list, (a, b) -> a.score == b.score ? a.sentence.compareTo(b.sentence) : b.score - a.score);

            for (int i = 0; i < Math.min(3, list.size()); i++) {
                result.add(list.get(i).sentence);
            }
        }
        return result;        
    }
}
