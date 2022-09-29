import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleIOServiceImpl implements PayrollService {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void read() {
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        System.out.println("Enter employee name");
        String name = scanner.next();
        System.out.println("Enter employee salary");
        long salary = scanner.nextLong();
        EmployeeData employeePayroll= new EmployeeData(id, name, salary);
        System.out.println(employeePayroll);
    }

    @Override
    public boolean write(List<EmployeeData> employeePayrollDataList) throws IOException {
        employeePayrollDataList.forEach(employeeData -> System.out.println(employeeData));
        return true;
    }

    @Override
    public long countEntries() throws IOException {
        return 0;
    }
}
