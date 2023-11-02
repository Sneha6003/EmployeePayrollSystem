import java.util.*;
//Creating an abstract class named employee
abstract class Employee{
    private String name; //access modifier is used
    private int id;
    
    //Creating a constructor
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    //creating a method(use of encapsulation)
    public String getName(){
        return name;

    }
    public int getId(){
        return id;
    }
    //creating an abstract method to calculate salary
    public abstract double calculateSalary();
    
    //use of polymorphism
    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

//creating a class for full time employee
//FullTimeEmployee inherits Employee class
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    //creating a constructor of the class
    public FullTimeEmployee(String name,int id,double monthlySalary){
        //using keyword "super" to access parent class constructor
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
//Now creating PartTimeEmployee class which inherits class Employee
class PartTimeEmployee extends Employee{
    //we need to calculate hourly salary of part time employees
    private int hoursWorked;
    private double hourlyRate;

    //creating a constructor
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

//creating class payroll system
class PayrollSystem{
    //creating array list named employeeList
    private ArrayList<Employee>employeeList;

    //creating a constructor
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    //creating a method to add employee
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    //method to remove employee
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        //running for each loop to remove the desired employee using it's id
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    //method to display the employee
    public void displayEmployees(){
        //running for loop to display the employee(s)
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

//creating a main method to access the above 
public class oopProject{
    public static void main(String args[]){
       //creating object of PayrollSystem class
       PayrollSystem payrollSystem= new PayrollSystem();
       //creating object of FullTimeEmployee class and PartTimeEmployee class
       FullTimeEmployee emp1=new FullTimeEmployee("Vikas",1,70000);
       PartTimeEmployee emp2=new PartTimeEmployee("Rahul", 2, 40, 100);

       //to add employee in array list
       payrollSystem.addEmployee(emp1);
       payrollSystem.addEmployee(emp2);
       //to display employees
       System.out.println("Initial Employee Details: ");
       payrollSystem.displayEmployees();
       //to remove employee
       System.out.println("Removing Employees");
       payrollSystem.removeEmployee(2);
       //to know remaining employee details after removing
       System.out.println("Remaining Employee Details: ");
       payrollSystem.displayEmployees();
       


    }
}