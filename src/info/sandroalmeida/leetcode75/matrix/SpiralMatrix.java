package info.sandroalmeida.leetcode75.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean goRight = true;
        boolean goDown = true;
        int minX = 0, maxX = matrix[0].length - 1;
        int minY = 0, maxY = matrix.length - 1;
        List<Integer> result = new ArrayList<>();

        while(minX <= maxX && minY <= maxY){
            if(goRight && goDown){
                for(int i = minX; i <= maxX; i++){
                    result.add(matrix[minY][i]);
                }
                goRight = false;
                minY++;
            } else if(!goRight && goDown){
                for(int i = minY; i <= maxY; i++){
                    result.add(matrix[i][maxX]);
                }
                goDown = false;
                maxX--;
            } else if(!goRight){
                for(int i = maxX; i >= minX; i--){
                    result.add(matrix[maxY][i]);
                }
                goRight = true;
                maxY--;
            } else{
                for(int i = maxY; i >= minY; i--){
                    result.add(matrix[i][minX]);
                }
                goDown = true;
                minX++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int [][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result1 = spiralOrder(matrix1);
        for(int i: result1)
            System.out.print(i + "-");

        System.out.println("");

        int[][] matrix2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result2 = spiralOrder(matrix2);
        for(int i: result2)
            System.out.print(i + "-");

        System.out.println("");

        int[][] matrix3 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> result3 = spiralOrder(matrix3);
        for(int i: result3)
            System.out.print(i + "-");
    }
}
