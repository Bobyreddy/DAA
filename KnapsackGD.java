/*
Implement in Java, the 0/1 Knapsack problem using Greedy method.
*/

import java.util.*;

public class KnapsackGD {
    double wt[], profit[], ratio[], m, sum;

    KnapsackGD() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of objects: ");
        int n = sc.nextInt();
        wt = new double[n];
        profit = new double[n];
        ratio = new double[n];
        System.out.println("Enter the objects weights: ");
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextDouble();
        System.out.println("Enter the objects profits: ");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextDouble();
            ratio[i] = profit[i] / wt[i];
        }
        System.out.println("Enter the capacity of knapsack: ");
        m = sc.nextDouble();
        sc.close();
    }

    int getNext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < profit.length; i++) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        System.out.println("Objects considered: ");
        while (m > 0) {
            int item = getNext();
            if (item == -1)
                break;
            System.out.print((item + 1) + " ");
            if (wt[item] <= m) {
                m = m - wt[item];
                sum = sum + profit[item];
                ratio[item] = 0;
            } else {
                sum = sum + (profit[item] * (m / wt[item]));
                m = 0;
                break;
            }
        }
        System.out.println("\nThe optimal solution i.e. Max. Profit = " + sum);
    }

    public static void main(String[] args) {
        KnapsackGD kdg = new KnapsackGD();
        kdg.fill();
    }
}