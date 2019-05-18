package ua.polosmak.task2;

/**
 * @author Roman Polosmak
 */

public class Matrix {
    private int[][] cost;// An array that contains the value of the ribs

    /**
     * @param vertices the number of vertices in the graph
     */
    public Matrix(int vertices) {
        cost = new int[vertices][vertices];
    }

    /* Set the weight between the neighbors */
    public void setEdge(int i, int j, int weight) {
        cost[i][j] = weight;
    }

    /**
     * @param i
     * @param j
     * @return Returns 0 if I and J are the same, a large number of returns if there is no connection between the tops of the ribs or weight
     **/
    private int getCost(int i, int j) {
        /* [0, 1, 3, 0]
         * [1, 0, 1, 4]
         * [3, 1, 0, 1]
         * [0, 4, 1, 0]*/
        if (i == j) {
            return 0;
        }
        if (cost[i][j] == 0) {
            return 10001;
        }
        return cost[i][j];
    }

    /**
     * @return return the index of the smallest element of distances,
     * ignoring those in visited
     */
    private int cheapest(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) {
                best = i;
            }
        }
        return best;
    }

    /**
     * Return an array of the distances from source to each other vertex
     **/
    public Integer[] distancesFrom(int source) {
        Integer[] result = new Integer[cost.length];
        java.util.Arrays.fill(result, 10001);// Set tops mark
        result[source] = source;//Assign 1st top mark equal to "source"
        boolean[] visited = new boolean[cost.length];// visit the city
        for (int[] aCost : cost) {
            int City = cheapest(result, visited);// Select the top of which has a minimum mark
            visited[City] = true;// Marking visited vertex
            for (int j = 0; j < cost.length; j++) {
                result[j] = Math.min(result[j], result[City] + getCost(City, j));// Write the smallest cost from one vertex to another
            }
        }
        return result;
    }
}
