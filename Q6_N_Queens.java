
import java.util.*;
public class Q6_N_Queens {
    public static void main(String[] args) {
        int n = 4;

        // approach 1
        // here we use validate function which is taking 3O(n) so it makes tc as n3 so use optimise 
        // that using three arrays
        // ArrayList<ArrayList<String>> queen = solveNQueens(n);
        // System.out.println(queen);

        ArrayList<ArrayList<String>> queen = solveNQueens2(n);
        System.out.println(queen);
        
    }

    public static ArrayList<ArrayList<String>> solveNQueens2(int n){
        ArrayList<ArrayList<String>> queen = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        // left array size will be n
        int[] left = new int[n];
        // upper and lower diagonal size will be 2 * n - 1
        int[] upperDia = new int[2 * n - 1];
        int[] lowerDia = new int[2 * n - 1];

        dfs2(0, board, left, lowerDia, upperDia, queen); 
        return queen;
    }

    public static void dfs2(int col, char[][] board, int[] left, int[] lowerDia, int[] upperDia,
    ArrayList<ArrayList<String>> ans){
        if(col == board.length){
            ArrayList<String> ds = construct(board);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(left[row] == 0 && lowerDia[row + col] == 0 && upperDia[board.length - 1 + col - row] == 0){
                left[row] = 1;
                lowerDia[row + col] = 1;
                upperDia[board.length - 1 + col - row] = 1;
                board[row][col] = 'Q';
                dfs2(col + 1, board, left, lowerDia, upperDia, ans);
                board[row][col] = '.';
                left[row] = 0;
                lowerDia[row + col] = 0;
                upperDia[board.length - 1 + col - row] = 0;
            }
        }
    }
    public static void dfs(int col, char[][] board, ArrayList<ArrayList<String>> ans){
        if(col == board.length){
            ArrayList<String> ds = construct(board);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(validate(row, col, board) == true){
                board[row][col] = 'Q';
                dfs(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    public static ArrayList<String> construct(char[][] board){
        ArrayList<String> ds = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            String s = "";
            for(int j = 0; j < board.length; j++){
                s += board[i][j];
            }
            ds.add(s);
        }
        return ds;
    }

    public static boolean validate(int row, int col, char[][] board){
        int rrow = row;
        int ccol = col;

        // upside diagonal
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // in same row
        row = rrow;
        col = ccol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        // downside diagonal
        row = rrow;
        col = ccol;
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }
    public static ArrayList<ArrayList<String>> solveNQueens(int n){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        dfs(0, board, ans);

        return ans;
    }
}
