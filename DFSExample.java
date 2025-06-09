import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add an edge
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Remove this for a directed graph
    }

    // DFS using Map (Adjacency List)
    public void dfs(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        
        System.out.print(node + " ");
        visited.add(node);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbor, visited);
        }
    }
}
public class DFSExample {
    

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        System.out.println("DFS Traversal:");
        graph.dfs(0, new HashSet<>());

        StringBuilder d= new StringBuilder();
    }
    
}
        //      0
        //     /  \
        //    1    2
        //   /
        //  3
