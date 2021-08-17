/*
From a given vertex in a weighted connected graph, find shortest paths to other vertices using Dijkstra's algorithm. Write the program in Java.
*/

import java.nio.file.Path;
import java.util.*;

public class Dijkstra {
    int graph[][] = new int[10][10];
    int d[] = new int[10];
    int p[] = new int[10];
    int s[] = new int[10];
    int n, source, min;

    Dijkstra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex: ");
        source = sc.nextInt();
    }

    void initialize() {
        for (int i = 0; i < n; i++) {
            d[i] = graph[source][i];
            p[i] = source;
        }
        s[source] = 1;
    }

    void dijkstra() {
        relax(source);
        for (int i = 0; i < n; i++) {
            if (d[i] == 99)
                System.out.println(i + " is not reachable from " + source);
            if (i != source)
                print_path(source, i);
        }
    }

    void print_path(int src, int dest) {
        int i = dest;
        while (i != src) {
            System.out.print(i + " <-- ");
            i = p[i];
        }
        System.out.println(i + " = " + d[dest] + "\n");
    }

    void relax(int src) {
        for (int i = 1; i < n; i++) {
            min = 99;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (s[j] == 0) {
                    if (d[j] < min) {
                        min = d[j];
                        u = j;
                    }
                }
            }
            if (u == -1)
                return;
            s[u] = 1;
            for (int v = 0; v < n; v++) {
                if (s[v] == 0 && d[v] > d[u] + graph[u][v]) {
                    d[v] = d[u] + graph[u][v];
                    p[v] = u;
                }
            }
        }
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        d.initialize();
        d.dijkstra();
    }
}
