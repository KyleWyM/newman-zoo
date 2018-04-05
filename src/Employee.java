import ibio.*;
import sun.misc.Cleaner;

public class Employee {

    String name;
    int experience;
    int salary; //weekly salary

    public Employee(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }
    // TODO introducing some methods

    public void setSalary(double salary) {

        salary = this.salary + experience;

}

    public void addExperience(int experience) {
        this.experience = experience + totalMoney;
    }


}
