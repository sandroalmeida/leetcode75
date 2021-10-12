package info.sandroalmeida.graph;

import java.util.*;

/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells.
 * You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north,
 * south, east, and west if the neighboring cell's height is less than or equal to the current cell's height.
 * Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water
 * can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 * Example 1:
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Example 2:
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 *
 * Constraints:
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 *
 *
 * DON'T FILL UP ALL EDGE CASES
 * */
public class PacificAtlanticWaterFlow_V2 {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        List<List<Integer>> result = new ArrayList<>();

        for(int col = 0; col < COLS; col++){
            dfs(ROWS, COLS, heights, 0, col, pacific, heights[0][col]);
            dfs(ROWS, COLS, heights, ROWS - 1, col, atlantic, heights[ROWS - 1][col]);
        }

        for(int row = 0; row < ROWS; row++){
            dfs(ROWS, COLS, heights, row, 0, pacific, heights[row][0]);
            dfs(ROWS, COLS, heights, row, COLS - 1, atlantic, heights[row][COLS - 1]);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    public static void dfs(int ROWS, int COLS, int[][] heights, int row, int col, boolean[][] visitNodes, int prevHeight){
        if(row < 0 || col < 0 || row == ROWS || col == COLS) return;

        int cur = heights[row][col];
        if(visitNodes[row][col] || cur < prevHeight) return;

        visitNodes[row][col] = true;
        dfs(ROWS, COLS, heights, row + 1, col, visitNodes, cur);
        dfs(ROWS, COLS, heights, row - 1, col, visitNodes, cur);
        dfs(ROWS, COLS, heights, row, col + 1, visitNodes, cur);
        dfs(ROWS, COLS, heights, row, col - 1, visitNodes, cur);
    }

    public static void main(String[] args) {
        int[][] heights_1 = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result_1 = pacificAtlantic(heights_1);
        for(List<Integer> coordinates: result_1){
            System.out.println(coordinates.get(0) + "-" + coordinates.get(1));
        }

        int[][] heights_2 = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        List<List<Integer>> result_2 = pacificAtlantic(heights_2);
        for(List<Integer> coordinates: result_2){
            System.out.println(coordinates.get(0) + "-" + coordinates.get(1));
        }
    }
}
