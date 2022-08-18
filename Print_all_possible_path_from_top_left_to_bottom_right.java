import java.util.ArrayList;

public class Print_all_possible_path_from_top_left_to_bottom_right {
    public static void main(String[] args) {
        int[][] maze = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        printPaths(0, 0, maze, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    public static void printPaths(int row, int col, int[][] maze, ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> ans) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length)
            return;
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ds.add(maze[row][col]);
            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size() - 1);
            return;
        }

        ds.add(maze[row][col]);
        printPaths(row, col + 1, maze, ds, ans);
        printPaths(row + 1, col, maze, ds, ans);
        ds.remove(ds.size() - 1);
    }
}
