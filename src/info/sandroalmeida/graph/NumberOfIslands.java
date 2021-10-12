package info.sandroalmeida.graph;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    count++;
                    dfs(grid, visited, ROWS, COLS, row, col);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, boolean[][] visited, int ROWS, int COLS, int row, int col){
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS) return;
        if(visited[row][col] || grid[row][col] == '0') return;

        visited[row][col] = true;
        dfs(grid, visited, ROWS, COLS, row + 1, col);
        dfs(grid, visited, ROWS, COLS, row - 1, col);
        dfs(grid, visited, ROWS, COLS, row, col + 1);
        dfs(grid, visited, ROWS, COLS, row, col - 1);
    }


    public static void main(String[] args) {
        char[][] input = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','1','0'}};
        System.out.println(numIslands(input));
    }
}
