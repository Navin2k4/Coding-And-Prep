def island_perimeter(grid):
    rows = len(grid)
    cols = len(grid[0])
    perimeter = 0
    for i in range(rows):
        for j in range(cols):
            if grid[i][j] == 1:
                perimeter += 4
                if i > 0 and grid[i - 1][j] == 1:
                    perimeter -= 2
                if j > 0 and grid[i][j - 1] == 1:
                    perimeter -= 2

    return perimeter

def island_perimeter_dfs(grid):
    def dfs(r, c):
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]):
            return 1
        if grid[r][c] == 0:
            return 1
        if grid[r][c] == -1:
            return 0
        grid[r][c] = -1  
        perimeter = 0
        perimeter += dfs(r - 1, c)  
        perimeter += dfs(r + 1, c) 
        perimeter += dfs(r, c - 1)  
        perimeter += dfs(r, c + 1)  
        return perimeter

    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == 1:
                return dfs(i, j)

    return 0


if __name__ == "__main__":
    grid = [
        [0, 1, 0, 0],
        [1, 1, 1, 0],
        [0, 1, 0, 0],
        [1, 1, 0, 0]
    ]
    print("Perimeter (DFS):", island_perimeter_dfs([row[:] for row in grid])) 
