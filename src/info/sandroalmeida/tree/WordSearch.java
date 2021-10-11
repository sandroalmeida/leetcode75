package info.sandroalmeida.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 * */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>();

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(dfs(board, word.toCharArray(), row, col, 0, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] chars, int row, int col, int index, Set<String> visited){
        String node = row + "" + col;

        if(index == chars.length) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(chars[index] != board[row][col]) return false;
        if(visited.contains(node)) return false;

        visited.add(node);

        boolean check = dfs(board, chars, row + 1, col, index + 1, visited) ||
                        dfs(board, chars, row - 1, col, index + 1, visited) ||
                        dfs(board, chars, row, col + 1, index + 1, visited) ||
                        dfs(board, chars, row, col - 1, index + 1, visited);
        visited.remove(node);
        return check;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

}
