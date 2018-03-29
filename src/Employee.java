import ibio.*;


import java.util.ArrayList;

public class Employee {

    String ID;
    int experience;
    double salary; //weekly salary

    public Employee(String ID, int experience, double salary) {
        this.ID = ID;
        this.experience = experience;
        this.salary = salary;
    }
    // TODO introducing some methods

    public void setSalary(double salary) {

        salary = this.salary + experience;



    }



    public static void main(String args[]) {
        int minEmployees = 20;

        ArrayList<Employee> myEmployees = new ArrayList<>();

        for (int i =0; i < minEmployees; i++) {
            myEmployees.add(new Employee(String.format("%d", i+1), 1, 28));
        }

        for (int i =0; i < minEmployees; i++) {
            String.format("ID Employee %s", "has salary %f",  "and his ID id %d" );
            IBIO.output((myEmployees.get(i).salary));
        }

    }

}

