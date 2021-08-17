
/*
Implement in Java, the 0/1 Knapsack problem using Dynamic Programming method
*/
import java.util.*;

public class KnapsackDP {
    static void kanpsack(int wt[], int profit[], int m, int n) {
        int x[] = new int[n + 1];
        int v[][] = new int[n + 1][m + 1];
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (wt[i] <= j)
                    v[i][j] = Math.max(profit[i] + v[i - 1][j - wt[i]], v[i - 1][j]);
                else
                    v[i][j] = v[i - 1][j];
            }
        }
        System.out.println("the optimal solution is: " + v[n][m]);
        i = n;
        j = m;
        while (i != 0 && j != 0) {
            if (v[i][j] != v[i - 1][j]) {
                x[i] = 1;
                j = j - wt[i];
            }
            i--;
        }
        System.out.println("The objects selected are: ");
        for (int z = 1; z <= n; z++) {
            if (x[z] == 1)
                System.out.print(z + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of objects: ");
        int n = sc.nextInt();
        int wt[] = new int[n + 1];
        int profit[] = new int[n + 1];
        System.out.println("Enter the weight: ");
        for (int i = 1; i <= n; i++)
            wt[i] = sc.nextInt();
        System.out.println("Enter the profit: ");
        for (int i = 1; i <= n; i++)
            profit[i] = sc.nextInt();
        System.out.println("Enter the capacity");
        int m = sc.nextInt();
        kanpsack(wt, profit, m, n);
        sc.close();
    }
}
