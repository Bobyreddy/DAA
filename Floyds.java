
/*
Write Java programs to Implement All-Pairs Shortest Paths problem using Floyd's algorithm.
*/
import java.util.Scanner;

public class Floyds {
    int cost[][];
    int n;

    Floyds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        n = sc.nextInt();
        cost = new int[n + 1][n + 1];
        System.out.println("Enter the cost matrix: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
    }

    void floyds() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        printAllPairShortestPath();
    }

    void printAllPairShortestPath() {
        System.out.println("The shortest path matrix is: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Floyds f = new Floyds();
        f.floyds();
    }
}
