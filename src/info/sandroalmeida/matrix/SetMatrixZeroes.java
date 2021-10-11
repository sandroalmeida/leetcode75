package info.sandroalmeida.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 *
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * */
public class SetMatrixZeroes {

    static int ROWS;
    static int COLS;

    public static void setZeroes(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        List<int[]> zeroLocations = new ArrayList<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(matrix[i][j] == 0){
                    zeroLocations.add(new int[]{i, j});
                }
            }
        }
        turnZero(matrix, zeroLocations);
    }

    public static void turnZero(int[][] matrix, List<int[]> zeroLocations){
        boolean[][] visited = new boolean[ROWS][COLS];

        for(int[] location: zeroLocations){
            int row = location[0];
            int col = location[1];

            for(int x = 0; x < COLS; x++){
                if(!visited[row][x]){
                    matrix[row][x] = 0;
                    visited[row][x] = true;
                }
            }

            for(int x = 0; x < ROWS; x++){
                if(!visited[x][col]){
                    matrix[x][col] = 0;
                    visited[x][col] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1,1,1},{1,0,1,0,1},{1,1,1,1,1}};
        setZeroes(matrix);
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
