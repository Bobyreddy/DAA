/*
Design a superclass called Staff with details as StaffId, Name, Phone, Salary. Extend this class by writing three subclasses namely Teaching 
(domain, publications), Technical (skills), and Contract (period). Write a Java program to read and display atleast 3 staff objects of all three 
categories.
*/

class Staff {
    String StaffId, Name, Phone, Salary;

    Staff(String StaffId, String Name, String Phone, String Salary) {
        this.StaffId = StaffId;
        this.Name = Name;
        this.Phone = Phone;
        this.Salary = Salary;
    }

    void display() {
        System.out.print(StaffId + "\t\t");
        System.out.print(Name + "\t\t");
        System.out.print(Phone + "\t\t");
        System.out.print(Salary + "\t\t");
    }
}

class Teaching extends Staff {
    String domain, publications;

    Teaching(String StaffId, String Name, String Phone, String Salary, String domain, String publications) {
        super(StaffId, Name, Phone, Salary);
        this.domain = domain;
        this.publications = publications;
    }

    void display() {
        super.display();
        System.out.print(domain + "\t\t");
        System.out.print(publications + "\t\t");
        System.out.println();
    }
}

class Technical extends Staff {
    String skills;

    Technical(String StaffId, String Name, String Phone, String Salary, String skills) {
        super(StaffId, Name, Phone, Salary);
        this.skills = skills;
    }

    void display() {
        super.display();
        System.out.print(skills + "\t\t");
        System.out.println();
    }
}

class Contract extends Staff {
    String period;

    Contract(String StaffId, String Name, String Phone, String Salary, String period) {
        super(StaffId, Name, Phone, Salary);
        this.period = period;
    }

    void display() {
        super.display();
        System.out.print(period + "\t\t");
        System.out.println();
    }

}

class StaffClass {
    public static void main(String[] args) {
        Teaching t1 = new Teaching("10", "A", "123456789", "12121", "cs", "4");
        Teaching t2 = new Teaching("20", "B", "311212121", "32322", "is", "3");
        Teaching t3 = new Teaching("30", "C", "343433433", "34343", "ece", "4");
        Technical te1 = new Technical("11", "D", "31231231", "12321", "C");
        Technical te2 = new Technical("12", "E", "23324322", "24234", "C++");
        Technical te3 = new Technical("13", "F", "23432323", "23432", "Java");
        Contract c1 = new Contract("22", "G", "342343223", "23423", "2");
        Contract c2 = new Contract("23", "H", "234322322", "32423", "3");
        Contract c3 = new Contract("24", "I", "234322322", "32432", "4");
        System.out.println("--------------Teaching Staff details-------");
        System.out.println("ID\t\tName\t\tPhonenumber\t\tSalary\t\tDomain\t\tPublications");
        t1.display();
        t2.display();
        t3.display();
        System.out.println("--------------Technical Staff details------");
        System.out.println("ID\t\tName\t\tPhonenumber\t\tSalary\t\tskills");
        te1.display();
        te2.display();
        te3.display();
        System.out.println("--------------Contract Staff details-------");
        System.out.println("ID\t\tName\t\tPhonenumber\t\tSalary\t\tPeriod");
        c1.display();
        c2.display();
        c3.display();
    }
}