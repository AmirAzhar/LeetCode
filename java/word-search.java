// https://leetcode.com/problems/word-search/submissions/

// Java
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] charArr = word.toCharArray();

        // iterate through array to find start of word to start search
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++){
                // if start of word and the dfs return true
                if (board[r][c] == charArr[0] && dfs(board, charArr, rows, cols, r, c, 0 )) return true;
            }
        }

        // raech this point means no match so return false
        return false;
    }

    public boolean dfs(char[][] board, char[] charArr, int rows, int cols, int r, int c, int id) {
        // base case 1: reached end of word
        if (id == charArr.length) return true;

        // base case 2: out of bounds or not the same char
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != charArr[id]) return false;

        // keep track temp
        char temp = board[r][c];

        // set visited
        board[r][c] = '#';

        // check all directions
        boolean found = dfs(board, charArr, rows, cols, r + 1, c, id + 1) ||
                        dfs(board, charArr, rows, cols, r - 1, c, id + 1) ||
                        dfs(board, charArr, rows, cols, r, c + 1, id + 1) ||
                        dfs(board, charArr, rows, cols, r, c - 1, id + 1);

        // reset the value to ensure future dfs not affected, and return
        board[r][c] = temp;

        return found;
    }
}

// JS
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let rows = board.length, cols = board[0].length;

    function dfs(r, c, id) {
        if (word.length === id) return true;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] !== word[id]) return false;

        let temp = board[r][c]; 
        board[r][c] = '#';

        let found = dfs(r+1, c, id+1) || dfs(r-1, c, id+1) || dfs(r, c+1, id+1) || dfs(r, c-1, id+1);

        board[r][c] = temp; 
        return found;
    }

    for (let r = 0; r < rows; r++){
        for (let c = 0; c < cols; c++){
            if (board[r][c] === word[0] && dfs(r, c , 0)) return true;
        }
    }

    return false;
};

// i want to perform a sort of dfs
// i will start to iterate the board and look for the first letter to start the dfs
// dfs will take in board, wordArr, pointer (curr letter), r, c -> recursive
    // base case 1: pointer == length -> return true
    // base case 2: board[r][c] != word[pointer] -> return false
    // visit the cell by marking as "#"
    // found = dfs of all directions
    // reset cell to # to backtrack
    // return found