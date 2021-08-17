/*
Sort a given set of n integer elements using Merge Sort method and compute its time complexity.
Run the program for varied values of n> 5000, and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or can be generated using the random number generator. 
Demonstrate using Java how the divideand-conquer method works along with its time complexity analysis: worst case, average case and best case.
*/

import java.io.*;
import java.util.*;

public class MergeSort {
    int n;
    int a[];

    MergeSort() {
        System.out.println("Enter the array size: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt(20);
        try {
            calc();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    void calc() throws FileNotFoundException {
        PrintStream o = new PrintStream(new File("B.txt"));
        PrintStream console = System.out;
        System.out.println();
        mergesort(a, 0, n - 1);
        System.out.println("Array elements to be sorted are: ");
        System.out.println("Please refer the file");
        System.setOut(o);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        long startTime = System.nanoTime();
        mergesort(a, 0, n - 1);
        long stopTime = System.nanoTime();
        long elapseTime = (stopTime - startTime);
        System.out.println("\nThe sorted elements are: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.setOut(console);
        long estimatedTime = stopTime - startTime;
        System.out.println("\nMerge Sort in avg. case is: " + (estimatedTime / 100000000.0) + " s");
        System.out.println("**************************************************************");
        startTime = System.nanoTime();
        mergesort(a, 0, n - 1);
        stopTime = System.nanoTime();
        estimatedTime = stopTime - startTime;
        System.out.println("\nMerge Sort in best Case is: " + (estimatedTime / 100000000.0) + " s");
        System.out.println("**********************************************************");
        generateWorstCase(a, 0, n - 1);
        startTime = System.nanoTime();
        mergesort(a, 0, n - 1);
        stopTime = System.nanoTime();
        estimatedTime = stopTime - startTime;
        System.out.println("\nMerge sort in worst case is: " + (estimatedTime / 100000000.0) + " s");
        System.out.println("****************************************************************");

    }

    void generateWorstCase(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            int left[] = new int[m - l + 1];
            int right[] = new int[r - m];
            split(arr, left, right, l, m, r);
            generateWorstCase(left, m + 1, r);
            join(arr, left, right, l, m, r);
        }
    }

    static void join(int arr[], int left[], int right[], int l, int m, int r) {
        int i;
        for (i = 0; i <= m - l; i++)
            arr[i] = left[i];
        for (int j = 0; j < r - m; j++)
            arr[i + j] = right[j];
    }

    static void split(int arr[], int left[], int right[], int l, int m, int r) {
        for (int i = 0; i <= m - l; i++)
            left[i] = arr[i * 2];
        for (int i = 0; i < r - m; i++)
            right[i] = arr[i * 2 + 1];
    }

    void mergesort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(low, mid, high);
        }
    }

    void merge(int l, int m, int h) {
        int i = l;
        int j = m + 1;
        int k = l;
        int resarray[] = new int[n];
        while (i <= m && j <= h) {
            if (a[i] < a[j]) {
                resarray[k] = a[i];
                i++;
                k++;
            } else {
                resarray[k] = a[j];
                j++;
                k++;
            }
        }

        while (i <= m) {
            resarray[k++] = a[i++];
        }
        while (j <= h) {
            resarray[k++] = a[j++];
        }
        for (int x = l; x <= h; x++) {
            a[x] = resarray[x];
        }
    }

    public static void main(String args[]) {
        new MergeSort();
    }
}
