package info.sandroalmeida.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 * */
public class WordSearchII {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> foundList = new ArrayList<>();
        Set<String> visited;

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                for(String word: words){
                    if(dfs(board, word.toCharArray(), row, col, 0, new HashSet<>()))
                        foundList.add(word);
                }
            }
        }
        return foundList;
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
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> result = findWords(board, words);
        for(String s: result)
            System.out.println(s);
    }
}
