
/*
Write a Java program to read two integers a andb. Compute a/b and print, when b 
is notzero. Raise an exception when b is equal to zero.
*/
import java.util.Scanner;

public class ExeptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a : ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();

        try {
            int c = a / b;
            System.out.println("result: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Exception : " + e);
        }
    }
}
