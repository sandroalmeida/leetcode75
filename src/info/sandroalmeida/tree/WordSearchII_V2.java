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
public class WordSearchII_V2 {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> foundList = new ArrayList<>();
        Set<String> visited;
        Trie trie = new Trie();
        buildTrie(board, trie);

        for(String s: words){
            if(trie.search(s))
                foundList.add(s);
        }
        return foundList;
    }

    public static void buildTrie(char[][] board, Trie trie){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                dfsInsertWord(board, trie, "", row, col, new HashSet<>());
            }
        }
    }

    public static void dfsInsertWord(char[][] board, Trie trie, String currentWord, int row, int col, Set<String> visited){
        String node = row + "" + col;

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
        if(visited.contains(node)) return;

        currentWord = currentWord + board[row][col];

        visited.add(node);

        trie.insert(currentWord);

        dfsInsertWord(board, trie, currentWord, row + 1, col, visited);
        dfsInsertWord(board, trie, currentWord, row - 1, col, visited);
        dfsInsertWord(board, trie, currentWord, row, col + 1, visited);
        dfsInsertWord(board, trie, currentWord, row, col - 1, visited);

        visited.remove(node);

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> result = findWords(board, words);
        for(String s: result)
            System.out.println(s);
    }
}
