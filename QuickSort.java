/*
Sort a given set of n integer elements using Quick Sort method and compute its time complexity. 
Run the program for varied values of n> 5000 and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or can be generated using the random number generator. 
Demonstrate using Java how the divideand-conquer method works along with its time complexity analysis: worst case, average case and best case.
*/

import java.util.*;
import java.io.*;

public class QuickSort {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintStream o = new PrintStream(new File("A.txt"));
        PrintStream console = System.out;
        System.out.println("Enter the no. of elements to be sorted: ");
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n);
        }

        System.out.println("Array elements to be sorted are: ");
        System.out.println("Please refer file");
        System.setOut(o);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i] + " ");
        }

        a[n] = 99999;
        long start = System.nanoTime();
        qsort(a, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("\nThe sorted elements are: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.setOut(console);
        long estimatedTime = end - start;
        System.out.println("\n Quick sort in Avg. Case: " + (estimatedTime / 1000000000.0) + "s");
        System.out.println("************************************************");
        start = System.nanoTime();
        qsort(a, 0, n - 1);
        end = System.nanoTime();
        estimatedTime = end - start;
        System.out.println("\n Quick sort in Worst Case: " + (estimatedTime / 1000000000.0) + "s");
        System.out.println("************************************************");
        bestcasegen(a, 0, n - 1);
        start = System.nanoTime();
        qsort(a, 0, n - 1);
        end = System.nanoTime();
        estimatedTime = end - start;
        System.out.println("\n Quick sort in Best case: " + (estimatedTime / 1000000000.0) + "s");
        System.out.println("************************************************");
    }

    static void bestcasegen(int arr[], int begin, int end) {
        int count = end - begin + 1;
        if (count <= 2)
            return;
        int middle = (begin + end) / 2;
        bestcasegen(arr, begin, middle);
        swap(arr, begin, middle);
        bestcasegen(arr, ++middle, end);
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void qsort(int a[], int p, int q) {
        int j;
        if (p < q) {
            j = partition(a, p, q);
            qsort(a, p, j - 1);
            qsort(a, j + 1, q);
        }
    }

    static int partition(int a[], int m, int p) {
        int v, i, j;
        v = a[m];
        i = m;
        j = p;
        while (i <= j) {
            while (a[i] <= v)
                i++;
            while (a[j] > v)
                j--;
            if (i < j)
                swap(a, i, j);
        }
        a[m] = a[j];
        a[j] = v;
        return j;
    }

}