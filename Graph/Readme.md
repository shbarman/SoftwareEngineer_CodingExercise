# Introduction:

Data Structure which stores connected data like a network of people in social network.
A graph consists of vertices and edges.
1. ### Vertex:
    Represents the entity Eg: people to be connected or the path to be reached.
2. ### Edges:
    Serves as the connection between the entities Eg: If a path exists between vertex A and vertex B

## Directed Graph

When Edges have directions between them it refers to as a directed graph.
Eg: (A) -> (B) this symbolizes a path exists in the direction of vertex A to vertex B.
This path is only in a fixed direction

## Undirected Graph

When Edges do not have any directions whatsoever and serves only as a connection between vertices.

## Weighted Graph

When edges have or carry relative weight in them so as to represent a factor of connection between two vertices.

# Graph Representation

## Adjacency Matrix

Graph is represented by a square matrix with dimensions equivalent to each vertices in the graph

Cons: Space storage efficiency is less

## Adjacency List

An Array of lists where the vertices represent the index and the adjacent vertices represent the arraylist.

Eg: if Vertex A has adjacent vertices as D and E the Adjacent list is represented by:

A -> D,E

# Graph Representation as Adjacency List
```
class Graph{
    private Map<Vertex , List<Vertex>> adjList;
}
```

```
#Vertex 
class Vertex {
    String label;
    Vertex(String label) {
        this.label = label;
    }
 
}
```

# Graph Traversal

## DFS - Depth First Search Traversal

Explore all adjacent vertices of a particular vertex(termed as root), before exploring the vertex at same level.

Exploration from DFS we use Stack to store all the vertices that needs to be visited next.
STACK --> LIFO

Starting from the source vertex A, we keep moving to the adjacent A to B to D where we reach the farthest level. Then we backtrack to the previous node B and pick an adjacent node. Once again, we explore till the farthest level where we hit the desired node G.
Time Complexity : O(V+E) where V is the number of vertices and E is the edges.
```
Set<String> depthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Stack<String> stack = new Stack<String>();
    stack.push(root);
    while (!stack.isEmpty()) {
        String vertex = stack.pop();
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (Vertex v : graph.getAdjVertices(vertex)) {              
                stack.push(v.label);
            }
        }
    }
    return visited;
}
```
NOTE: 

## BFS - Breadth First Search Traversal

It explores all vertices at present depth before moving on to the next level
It uses Queue for traversal.
Explore a vertex enqueue all its adjacent vertices
Dequeue a vertex mark it as visited and enqueue all its adjacent vertices into queue. We use visited array to remove infinite loop travesal.

Time Complexity : O(V+E) where V is the number of vertices and E is the edges.

```
Set<String> breadthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(root);
    visited.add(root);
    while (!queue.isEmpty()) {
        String vertex = queue.poll();
        for (Vertex v : graph.getAdjVertices(vertex)) {
            if (!visited.contains(v.label)) {
                visited.add(v.label);
                queue.add(v.label);
            }
        }
    }
    return visited;
}

```

# Union Find

To find key terms **Connected components , number of disjoint sets**.

This algorithm uses the objective of performing an union between two vertices if they are present in different sets.
For example : {1,9} {2,3,8} {7,4}

So to perform connection between vertex of 1 and 8 we have to perform union between the two subsets.
Steps to be followed:

1. Find function for 1 and 8 which basically checks for -> parent(1) and parent(8)
2. if both return to be equal then union cannot be performed because both have the same parent hence, **a connection already exists**
3. else, perform union of the two by changing parent A to parent B

```
class DSU{
    int[] parent;
    public DSU(int N){
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }

    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int a, int b){
        int A = find(a), B = find(b);
        if(A!=B){
            parent[A] = B;
        }
    }
}

```
## Path Compression & Union By Rank ##
The above steps might result in an unbalanced graph, to resolve from the situation we use **Path Compression** 

Steps to be followed:
1. We rank the parent and then perform union. The code implementation can be seen below

```
class DSU{
    int[] parent;
    int[] rank;
    public DSU(int N){
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;

        rank = new int[size];    
    }

    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);

        return parent[x];
    }

    public boolean union(int a, int b){
        int A = find(a), B = find(b);
        if(A==B){
            return false;
        }else if(rank[A]>rank[B]){
            parent[B] = A;
        }else if(rank[B]>rank[A]){
            parent[A] = B;
        }else{
            parent[B] = A;
            rank[A]++;
        }
        return true;
    }
}

```
** Time Complexity for this approach results in O(NlogN) **

## Tarzan Algorithm / Detecting Critical Connections / Articulation Point ##

To detect critical connection i.e connection with one path connecting it with other vertices.
Brute force would be to remove each vertex and check whether on removing it number of components increases.
This algorithm checks for strongly connected component but also doesnot consider back edges connecting two components.
Back Edge is an edge that connects a vertex to a vertex that is discovered before it's parent
For this we use dfs concept with disc and low time consideration:

1. *Disc* The time when the node is first visited, during dfs traversal
2. *Low* The time to reach the topmost nearby ancestor with minimum disc value via the subnode.

*If a vertex u is having a child v such that the earliest discovered vertex that can be reached from the vertices in the subtree rooted at v has a discovery time greater than or equal to u, then  does not have a back edge, and thus u will be an articulation point.*

```
public void dfs(int node , int parent ,List<List<Integer>> graph, List<List<Integer>> result,boolean[] visited ){
        time++;
        lowTime[node] = time;
        highTime[node] = time;
        visited[node]=true;
        
        for(int next: graph.get(node)){
            if(parent == next ) continue;
            if(!visited[next]){
            dfs(next,node,graph,result,visited);
            lowTime[node] = Math.min(lowTime[node],lowTime[next]);
                if(highTime[node]<lowTime[next]){
                    result.add(Arrays.asList(node,next));
                }
                    
            }else{
                lowTime[node] = Math.min(highTime[next],lowTime[node]);
            }  
            
        }

```