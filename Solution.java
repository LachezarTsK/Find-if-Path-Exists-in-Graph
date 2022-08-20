
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    List<Integer>[] graph;

    public boolean validPath(int numberOfNodes, int[][] edges, int source, int destination) {
        createGraph(numberOfNodes, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfNodes];
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }

            List<Integer> neighbours = graph[current];
            for (int node : neighbours) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }

    private void createGraph(int numberOfNodes, int[][] edges) {
        graph = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
}
