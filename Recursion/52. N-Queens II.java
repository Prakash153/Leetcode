The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.


Solution : the solution is similar to nqueens porblem....just we have to declare golabl variable for the answer


code: 
class Solution {
     
    public boolean isSafe(int row, int col, char[][] board) {
        // store in different variables bcz we're gonna make changes in row and col
        // and we will further need the original values of row and col 
        int r= row;
        int c = col;
        
        // Note- We are not checking anything on the right bcz we have to place a queen on the right col
        
        // check if Q can attack to its straight left 
        while (col >= 0) {
            if (board[row][col] == 'Q') 
                return false;
            col--;
        }
        
        //  check if Q can attack to its upper left diagonal
        row = r;
        col = c;
        while (row >= 0 && col >=0) {
            if (board[row][col] == 'Q') 
                return false;
            row--;
            col--;
        }
        
        //  check if Q can attack to its lower left diagonal
        row = r;
        col = c;
        while (row < board.length && col >=0) {
            if (board[row][col] == 'Q') 
                return false;
            row++;
            col--;
        }
        
        return true;
    }
    int ans; // global variable
    public void solution(int col , char [][]board){
        if(col == board.length){
            ans++;
            return;
        }
         for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solution(col + 1, board);
                board[row][col] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
          char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        // list to store the final answer
        ans = 0;
        solution(0, board);
        return ans;
    }
}
