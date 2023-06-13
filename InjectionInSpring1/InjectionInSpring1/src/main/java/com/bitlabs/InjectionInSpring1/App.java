package com.bitlabs.InjectionInSpring1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DepartmentService departmentService = context.getBean("departmentService", DepartmentService.class);

        System.out.println("All Departments and Employees:");
        departmentService.displayDepartmentDetails();

        System.out.println("\nAdding a new employee to Department 1:");
        Employee newEmployee = new Employee("7", "Alex Turner", context.getBean("department1", Department.class));
        departmentService.addEmployeeToDepartment("1", newEmployee);
        departmentService.displayEmployeesByDepartment("1");
    }
}
