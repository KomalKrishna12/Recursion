public class Q7_Sudoku_solver {
    public static void main(String[] args) {
        char[][] board = {
                { '9', '5', '7', '.', '1', '3', '.', '8', '4' },
                { '4', '8', '3', '.', '5', '7', '1', '.', '6' },
                { '.', '1', '2', '.', '4', '9', '5', '3', '7' },
                { '1', '7', '.', '3', '.', '4', '9', '.', '2' },
                { '5', '.', '4', '9', '7', '.', '3', '6', '.' },
                { '3', '.', '9', '5', '.', '8', '7', '.', '1' },
                { '8', '4', '5', '7', '9', '.', '6', '1', '3' },
                { '.', '9', '1', '.', '3', '6', '.', '7', '5' },
                { '7', '.', '6', '1', '8', '5', '4', '.', '9' }
        };
        solve(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean solve(char[][] board){

        for(int row = 0; row < board.length; row++){

            for(int col = 0; col < board.length; col++){
                
                if(board[row][col] == '.'){

                    for(char c = '1'; c <= '9'; c++){

                        if(validate(row, col, c, board) == true){

                            board[row][col] = c;

                            if(solve(board) == true) return true;
                            else board[row][col] = '.';

                        }

                    }  

                    return false;

                }

            }
        }

        return true;

    }

    public static boolean validate(int row, int col, char c, char[][] board){

        for(int i = 0; i < 9; i++){

            // check in same row 
            if(board[row][i] == c) return false;

            // check in same col
            if(board[i][col] == c) return false;

            // check in the 3*3 matrix
            // firstly fins start row and col index for the given row and col
            // we find it using (3 * (row / 3 ) + i / 3) and (3 * (col / 3) + i % 3)
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == c) return false;

        }

        return true;

    }
}
