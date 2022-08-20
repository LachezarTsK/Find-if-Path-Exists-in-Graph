
/**
 * @param {number} numberOfNodes
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function (numberOfNodes, edges, source, destination) {
    this.graph = Array.from(new Array(numberOfNodes), () => new Array());
    createGraph(edges);

    const queue = new Queue();
    const visited = new Array(numberOfNodes).fill(false);
    queue.enqueue(source);
    visited[source] = true;

    while (!queue.isEmpty()) {
        const current = queue.dequeue();
        if (current === destination) {
            return true;
        }

        const neighbours = this.graph[current];
        for (let node of neighbours) {
            if (!visited[node]) {
                visited[node] = true;
                queue.enqueue(node);
            }
        }
    }
    return false;
};

/**
 * @param {number[][]} edges
 * @return {void}
 */
function createGraph(edges) {
    for (let edge of edges) {
        this.graph[edge[0]].push(edge[1]);
        this.graph[edge[1]].push(edge[0]);
    }
}
