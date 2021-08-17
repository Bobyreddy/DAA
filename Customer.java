
import java.util.*;

public class Customer {
    String name, dob;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        name = sc.nextLine();
        System.out.println("Enter dob: ");
        dob = sc.nextLine();
    }

    void display() {
        StringTokenizer st = new StringTokenizer(dob, "/", true);
        System.out.print(name + ",");
        while (st.hasMoreTokens()) {
            System.out.print(st.nextToken().replace("/", ","));
        }
    }

    public static void main(String[] args) {
        Customer c = new Customer();
        c.input();
        c.display();
    }
}
