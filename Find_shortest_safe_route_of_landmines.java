public class Find_shortest_safe_route_of_landmines {

    static int shortPath = Integer.MAX_VALUE;

    static int[] di = { 0, -1, 0, 1 };

    static int[] dj = { -1, 0, 1, 0 };

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };

        // mark all adjacent(up, down, left, right) of obstacle(0) as unsafe
        markUnsafe(mat);

        // mark all unsafe positions as 0 so we'll not traverse to that positions
        markZero(mat);

        boolean[][] vis = new boolean[mat.length][mat[0].length];

        shortestPath(0, 0, mat, 0, vis);

        System.out.println(shortPath);

    }

    public static void shortestPath(int row, int col, int[][] mat, int path, boolean[][] vis) {

        if(col == mat[0].length - 1){
            shortPath = Math.min(shortPath, path);
            return;
        }

        for(int dir = 0; dir < 4; dir++){
            int nrow = row + di[dir];
            int ncol = col + dj[dir];

            if(isValid(mat, nrow, ncol) == true && mat[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                vis[nrow][ncol] = true;
                shortestPath(nrow, ncol, mat, path + 1, vis);
                vis[nrow][ncol] = false;
            }
        }

    }

    public static boolean isValid(int[][] mat, int i, int j) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return false;

        return true;

    }

    public static void markZero(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] == -1) {

                    mat[i][j] = 0;

                }

            }

        }

    }

    public static void markUnsafe(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] == 0) {
                    // means it is abstacle so mark its nabr as -1 if they are available
                    for (int k = 0; k < 4; k++) {
                        if (isValid(mat, i + di[k], j + dj[k])) {
                            mat[i + di[k]][j + dj[k]] = -1;
                        }
                    }

                }

            }

        }

    }

    public static void print(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                System.out.print(mat[i][j] + " ");

            }

            System.out.println();

        }

        System.out.println();

    }

}
