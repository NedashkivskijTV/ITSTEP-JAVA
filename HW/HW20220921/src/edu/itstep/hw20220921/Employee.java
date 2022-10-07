package edu.itstep.hw20220921;

public class Employee extends User{
    private int wage; // зарплата
    private JobTitle jobTitle; // посада
    private Department department; // відділ

    public Employee(String fullName, int age, Gender gender, String email, Country country, int wage, JobTitle jobTitle, Department department) {
        super(fullName, age, gender, email, country);
        this.wage = wage;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Employee(Employee employee) {
        super(employee.getFullName(), employee.getAge(), employee.getGender(), employee.getEmail(), employee.getCountry());
        this.wage = employee.wage;
        this.jobTitle = employee.jobTitle;
        this.department = employee.department;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                " wage=" + wage +
                "$, jobTitle=" + jobTitle +
                ", department=" + department +
                "} ";
    }
}
