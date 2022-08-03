import java.util.*;
public class Q10_Rat_in_maze_problem_I {
    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1}, 
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};
         
        // method 1
        // in this we use four if statement for down, left, right , up
        // ArrayList<String> ans = findPath(m, n);
        // System.out.println(ans);             

        // method 2
        // in this we use single for loop for all four direction
        ArrayList<String> ans = findPath2(m, n);
        System.out.println(ans);
    }

    public static ArrayList<String> findPath2(int[][] board, int n){
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        int[] di = {+1, +0, +0, -1};
        int[] dj = {+0, -1, +1, +0};
        solve2(0, 0, board, vis, di, dj, ans, "");
        return ans;
    }

    public static void solve2(int row, int col, int[][] board, int[][] vis, int[] di, int[] dj,
    ArrayList<String> ans, String psf){
        if(row == board.length - 1 && col == board.length - 1){
            ans.add(psf);
            return;
        }

        String str = "DLRU";
        for(int i = 0; i < 4; i++){
            int nexti = row + di[i];
            int nextj = col + dj[i];

            if(nexti >= 0 && nextj >= 0 && nexti < board.length && nextj < board.length && 
            board[nexti][nextj] == 1 && vis[nexti][nextj] == 0){
                vis[row][col] = 1;
                solve2(nexti, nextj, board, vis, di, dj, ans, psf + str.charAt(i));
                vis[row][col] = 0;
            }
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0] == 0) return new ArrayList<>();
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        solve(0, 0, m, ans, vis, "");
        return ans;
    }
    public static void solve(int row, int col, int[][] m, ArrayList<String> ans, int[][] vis, String psf){
        if(row == m.length - 1 && col == m.length - 1){
            ans.add(psf);
            return;
        }
        
        // downwards
        if(row + 1 < m.length && m[row + 1][col] == 1 && vis[row + 1][col] == 0){
            vis[row][col] = 1;
            solve(row + 1, col, m, ans, vis, psf + "D");
            vis[row][col] = 0;
        }
        
        // leftwards
        if(col - 1 >= 0 && m[row][col - 1] == 1 && vis[row][col - 1] == 0){
            vis[row][col] = 1;
            solve(row, col - 1, m, ans, vis, psf + "L");
            vis[row][col] = 0;
        }
        
        // rightwards
        if(col + 1 < m.length && m[row][col + 1] == 1 && vis[row][col + 1] == 0){
            vis[row][col] = 1;
            solve(row, col + 1, m, ans, vis, psf + "R");
            vis[row][col] = 0;
        }
        
        // upwards
        if(row - 1 >= 0 && m[row - 1][col] == 1 && vis[row - 1][col] == 0){
            vis[row][col] = 1;
            solve(row - 1, col, m, ans, vis, psf + "U");
            vis[row][col] = 0;
        }
    }
}
