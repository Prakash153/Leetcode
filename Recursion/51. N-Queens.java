The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 
 
 Solution: 
1. create a board of nxn. 
2. start from column 0. 
3. try to place the queen in the column in different rows. 
4. if it's possible to place the queens, place it and call resursion for col+1 that is next column. 
5. remove the placed queens after coming back from recursion. 
6. follow the above steps.
7. isSafe function should check in 3 directtions .... left upper , left , left lower. 
  
  base case hits when column surpasses the length. 
  
  
  
  code: 
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //create the chess board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        // list to store the final answer
        List<List<String>> ans = new ArrayList<>();
        backtrack (0, board, ans);
        return ans;
    }
    
    public void backtrack (int col, char[][] board, List<List<String>> ans) {
        // base case
        if (col == board.length) {
            List<String> ds = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                ds.add(s);
            }
            ans.add(ds);
            return;
        }
        // check if you can place a queen in that particular position or not
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    
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
}
