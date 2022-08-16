import java.util.Arrays;

public class Knight_tour {

    public static void main(String args[]) {

        int n = 8;
        int[][] board = new int[n][n];

        for(int i = 0; i < board.length; i++){
            Arrays.fill(board[i], -1);
        }
        board[0][0] = 0;

        int[] dr = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

        solve(0, 0, 1, board, dr, dc);

    }

    public static boolean solve(int r, int c, int move, int[][] board, int[] dr, int[] dc){

        if(move == board.length * board.length){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        for(int i = 0; i < dr.length; i++){
            int nextr = r + dr[i];
            int nextc = c + dc[i];
            if(isSafe(board, nextr, nextc)){
                board[nextr][nextc] = move;
                if(solve(nextr, nextc, move + 1, board, dr, dc)) return true;
                board[nextr][nextc] = -1;
            }
        }

        return false;

    }

    public static boolean isSafe(int[][] board, int r, int c){

        if(r < 0 || c < 0 || r >= board.length || c >= board.length || board[r][c] != -1) return false;

        return true;

    }

}
