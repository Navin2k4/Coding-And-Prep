from graph import Graph
from collections import deque

def bfs(graph, V, start=1):
    bfs_order =[]
    visited = [False] * (V+1) 
    queue = deque()    
    queue.append(start)
    visited[start] = True
    while(queue):
        node = queue.popleft()
        bfs_order.append(node)
        for neighbour in graph.adj[node]:
            if not visited[neighbour]:
                visited[neighbour] = True
                queue.append(neighbour)
    return bfs_order


def dfs_recursive(graph, V, start=1):
    visited = [False] * (V + 1)
    dfs_order = []
    def dfs_helper(node):
        visited[node] = True
        dfs_order.append(node)
        for neighbor in graph.adj[node]:
            if not visited[neighbor]:
                dfs_helper(neighbor)
    dfs_helper(start)
    return dfs_order

def dfs_iterative(graph, V, start=1):
    visited = [False] * (V + 1)
    dfs_order = []
    stack = [start]
    while stack:
        node = stack.pop()
        if not visited[node]:
            visited[node] = True
            dfs_order.append(node)
            for neighbor in reversed(graph.adj[node]):
                if not visited[neighbor]:
                    stack.append(neighbor)
    return dfs_order


if __name__ == "__main__":
    g = Graph(8, is_directed=False)
    edges = [
        (1, 2), (1, 3), (2, 5), (2, 6),
        (3, 4), (3, 7), (4, 8), (7, 8)
    ]
    for u, v in edges:
        g.add_edge(u, v)
    
    result = bfs(g, g.V, 1)
    print(result)
    result = dfs_recursive(g, g.V, start=1)
    print(result)
    result = dfs_iterative(g, g.V, start=1)
    print(result)

