
/*
Write a Java program to implement the Stack using arrays. Write Push(), Pop(), andDisplay() methods to demonstrate its working
*/
import java.util.Scanner;

public class Stack {
    final int max = 5;
    int item, top = -1;
    int s[] = new int[max + 1];
    static Scanner sc = new Scanner(System.in);

    void push() {
        if (top == 5)
            System.out.println("stack overFlow!!");
        else {
            System.out.println("Enter the item to be inserted: ");
            item = sc.nextInt();
            s[++top] = item;
        }
    }

    void pop() {
        if (top == -1)
            System.out.println("Stack UnderFlow!!");
        else {
            item = s[top--];
            System.out.println(item + "Popped");
        }
    }

    void display() {
        if (top == -1)
            System.out.println("Stack UnderFlow!!");
        else {
            System.out.println("Stack contents are: ");
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack [%d] -> %d \n", i, s[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        System.out.println("--MENU--\n1.push\n2.pop\n3.display\n4.exit");
        while (true) {
            System.out.println("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }
}
