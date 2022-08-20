
#include <vector>
using namespace std;

class Solution {
    
    vector<vector<int>> graph;

public:
    bool validPath(int numberOfNodes, vector<vector<int>>& edges, int source, int destination) {
        createGraph(numberOfNodes, edges);
        
        queue<int> queue;
        vector<bool>visited(numberOfNodes);
        queue.push(source);
        visited[source] = true;

        while (!queue.empty()) {
            int current = queue.front();
            queue.pop();
            if (current == destination) {
                return true;
            }

            vector<int>& neighbours = graph[current];
            for (int node : neighbours) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.push(node);
                }
            }
        }
        return false;
    }

private:
    void createGraph(int numberOfNodes, const vector<vector<int>>& edges) {
        graph.resize(numberOfNodes);
        for (const auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
    }
};
