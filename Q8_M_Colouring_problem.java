import java.util.*;
// we have given n nodes we have to color each node with m colours so that no nbr or adjacent node
// have same color
public class Q8_M_Colouring_problem {
    public static void main(String[] args) {
        // N is total no of nodes
        // M is total no of colours
        int N = 4, M = 3;

        // graph
        // create n nodes
        // now connect their nbrs with that nodes
        ArrayList<ArrayList<Integer>> G = new ArrayList();
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }
        G.get(0).add(1);
        G.get(1).add(0);
        G.get(1).add(2);
        G.get(2).add(1);
        G.get(2).add(3);
        G.get(3).add(2);
        G.get(3).add(0);
        G.get(0).add(3);
        G.get(0).add(2);
        G.get(2).add(0);

        // this array will used to check the adjacent node colours
        int[] color = new int[N];

        boolean ans = graphColouring(0, G, color, M);

        if(ans == true) System.out.println("1");
        else System.out.println("0");
    }

    // this function will check every adjacent nodes of node if any color is matched then return false
    public static boolean isSafe(int node, int[] color, ArrayList<ArrayList<Integer>> graph, int i){
        for(int nbr : graph.get(node)){
            if(color[nbr] == i) return false;
        }
        return true;
    }

    public static boolean graphColouring(int node, ArrayList<ArrayList<Integer>> graph, int[] color, int M){
        // when we reach end means every nodes are coloured so return true
        if(node == color.length){
            return true;
        }

        // start coloring from 1 to m colors
        for(int i = 1; i <= M; i++){
            if(isSafe(node, color, graph, i)){
                color[node] = i;
                if(graphColouring(node + 1, graph, color, M)) return true;
                color[node] = 0;
            }
        }

        return false;
    }
}
