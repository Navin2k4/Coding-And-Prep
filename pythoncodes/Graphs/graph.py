class Graph:
    def __init__(self, vertices, is_directed=False):
        self.V = vertices
        self.is_directed = is_directed
        self.adj = {i: [] for i in range(1, vertices + 1)}

    def add_edge(self, u, v):
        self.adj[u].append(v)
        if not self.is_directed:
            self.adj[v].append(u)
            