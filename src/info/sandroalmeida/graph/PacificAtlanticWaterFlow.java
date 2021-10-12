package info.sandroalmeida.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int height = heights.length;
        int width = heights[0].length;

        boolean[][] flowPacific = new boolean[height][width];
        boolean[][] flowAtlantic = new boolean[height][width];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(i == 0 || j == 0) flowPacific[i][j] = true;
                if(i == height - 1 || j == width - 1) flowAtlantic[i][j] = true;
            }
        }

        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                int cur = heights[i][j];
                int topCur = heights[i - 1][j];
                int leftCur = heights[i][j - 1];
                if((cur >= topCur || cur >= leftCur) && (flowPacific[i - 1][j] || flowPacific[i][j - 1]))
                    flowPacific[i][j] = true;
            }
        }

        for(int i = height - 2; i >= 0; i--){
            for(int j = width - 2; j >= 0; j--){
                int cur = heights[i][j];
                int bottomCur = heights[i + 1][j];
                int rightCur = heights[i][j + 1];
                if((cur >= bottomCur || cur >= rightCur) && (flowAtlantic[i + 1][j] || flowAtlantic[i][j + 1]))
                    flowAtlantic[i][j] = true;
            }
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(flowPacific[i][j] && flowAtlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
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
