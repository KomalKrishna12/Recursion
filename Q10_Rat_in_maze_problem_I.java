import java.util.*;
public class Q10_Rat_in_maze_problem_I {
    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                     {1, 1, 0, 1}, 
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};
           
        ArrayList<String> ans = findPath(m, n);
        System.out.println(ans);             
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
