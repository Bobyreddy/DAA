/*
Find Minimum Cost Spanning Tree of a given connected undirected graph using Prim's algorithm
*/

import java.util.Scanner;

public class Prims {
    int n;
    int graph[][] = new int[10][10];
    int p[] = new int[10];
    int d[] = new int[10];
    int s[] = new int[10];
    int t[][] = new int[10][2];
    int sum, k, src, u, v;

    void createGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the adjcency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter an arbitarary vertex: ");
        src = sc.nextInt();
        sc.close();
    }

    void initialize() {
        for (int i = 0; i < n; i++) {
            d[i] = graph[src][i];
            p[i] = src;
        }
        s[src] = 1;
    }

    void MST() {
        for (int i = 1; i < n; i++) {
            int min = 99;
            for (int j = 0; j < n; j++) {
                if (s[j] == 0) {
                    if (d[j] <= min) {
                        min = d[j];
                        u = j;
                    }
                }
            }
            t[k][0] = u;
            t[k][1] = p[u];
            k++;
            sum += graph[u][p[u]];
            s[u] = 1;

            for (v = 0; v < n; v++) {
                if (s[v] == 0 && graph[u][v] < d[v]) {
                    d[v] = graph[u][v];
                    p[v] = u;
                }
            }
        }
    }

    void print() {
        if (sum >= 99) {
            System.out.println("Spanning tree does not exist");
        } else {
            for (int i = 0; i < n - 1; i++) {
                System.out.println(t[i][0] + " -> " + t[i][1]);
            }
            System.out.println("the cost of spanning tree is: " + sum);
        }
    }

    public static void main(String[] args) {
        Prims p = new Prims();
        p.createGraph();
        p.initialize();
        p.MST();
        p.print();
    }
}
