import java.util.*;
public class Graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}