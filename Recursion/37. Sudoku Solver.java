Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 
  
  
  codE: 
class Solution {
    public boolean isValid(char[][] board , int row , int col , char c){
        // for row
        for(int i = 0 ; i < board.length ; i++){
            if(board[row][i] == c)
            return false;
        }
        // for col
         for(int i = 0 ; i < board.length ; i++){
            if(board[i][col] == c)
            return false;
        }
        // for 3x3 box
        for(int i = 0 ; i < board.length ;i++){
            if(board[3*(row/3) + i/3] [3*(col/3) + i%3] == c)
            return false;
        }
        return true;
    }
    public boolean solve(char [][]board){
        // base case is when outer loop (row) ends
        for(int row = 0; row <board.length ; row++){
            for(int col = 0 ; col< board.length ; col++){
                if( board[row][col] == '.'){
                    for(char i = '1' ; i<= '9' ; i++){
                        if(isValid(board,row,col,i ) == true){
                            board[row][col] = i; 
                            // since we need one solution
                             if(solve(board) == true){
                                 return true;
                             }
                             // this is the case of backtracking
                             else{
                                 board[row][col] = '.';
                             }
                        }

                    }
// this is the case when there is no possiblity of placing element
                      return false;
                }
               
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
