
/*
Find Minimum Cost Spanning Tree of a given connected undirected graph using Kruskal'salgorithm
*/
import java.util.*;

public class Kruskal {
    int cost[][] = new int[10][10];
    int s[] = new int[10];
    int t[][] = new int[10][10];
    int n, sum, k, u, v, count;

    Kruskal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter teh adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            s[i] = i;
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    int findParent(int v) {
        while (s[v] != v) {
            v = s[v];
        }
        return v;
    }

    void kruskal() {
        int i, j;
        while (count < n - 1) {
            int min = 99;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (min > cost[i][j]) {
                        min = cost[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            if (min == 99)
                break;
            i = findParent(u);
            j = findParent(v);
            if (i != j) {
                t[k][0] = u;
                t[k][1] = v;
                sum += min;
                k++;
                count++;
                s[v] = u;
            }
            cost[u][v] = cost[v][u] = 99;
            PrintTree();
        }
    }

    void PrintTree() {
        if (count == n - 1) {
            System.out.println("Cost of Spanning tree is: " + sum);
            System.out.println("The spanning tree is: ");
            for (k = 0; k < n - 1; k++) {
                System.out.println(t[k][0] + " - " + t[k][1]);
            }
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        k.kruskal();
    }
}
