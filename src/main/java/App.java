import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.service.impl.EmployeeServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class App
{
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService;
    static {
        employeeService = new EmployeeServiceImpl();
    }
    public static void main( String[] args ) {
        String choice = null;
        do{
            System.out.println("Enter your Choice : ");
            System.out.println("1. Insert\n2. Delete\n3. Update\n4. Select One\n5. Select All");
            int option = scanner.nextInt();
            try{

                switch (option){
                    case 1:
                        insertEmployee();
                        break;
                    case 2:
                        deleteEmployee();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        getOneEmployee();
                        break;
                    case 5:
                        getAllEmployees();
                        break;
                    default:
                        System.out.println("Enter valid option : ");
                }
                System.out.println("Do you want to continue , (y/n) ?");
                choice = scanner.next();

            }
            catch (SQLException ex){
                ex.printStackTrace();
            }

        }while(choice.equalsIgnoreCase("y"));

    }
    private static void insertEmployee() throws SQLException{

        Employee employee = new Employee(102,"abhi","banglore",24,"it");
        int eid = -1;
        eid = employeeService.saveEmployee(employee);
        if(eid!=-1){
            System.out.println("Employee with id "+eid+" saved to DB !");
        }else{
            System.out.println("Not saved !!");
        }

    }
    private static void deleteEmployee() throws SQLException{
        System.out.println("Enter employee id : ");
        int id = scanner.nextInt();
        employeeService.deleteEmployee(id);
        System.out.println("employee deleted !!");
    }
    private static void updateEmployee() throws SQLException{
        System.out.println("Enter id of employee to update : ");
        int eid = scanner.nextInt();
        Employee employee = new Employee(eid,"abhi","banglore",24,"it");
        employeeService.updateEmployee(employee);

        System.out.println("Employee updated !!");
        System.out.println(employee);

    }
    private static void getOneEmployee() throws SQLException{
        System.out.println("Enter employee id : ");
        int id = scanner.nextInt();
        Employee employee = employeeService.getOneEmployee(id);
        System.out.println(employee);
    }
    private static void getAllEmployees() throws SQLException{
        List<Employee> employeeList = employeeService.getAllEmployees();
        System.out.println(employeeList);
    }
}
