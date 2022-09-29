import java.io.IOException;
import java.util.List;

public class EmployeePayrollService {
    List<EmployeeData> employeeDataList;
    public enum IOService{
        CONSOLE_IO, FILE_IO
    }

    public EmployeePayrollService(List<EmployeeData> employeeDataList) {
        this.employeeDataList = employeeDataList;
    }
    void writeEmployeePayrollData(IOService ioService) throws IOException {
        PayrollService payrollService=getEmployeePayrollObject(ioService);
        payrollService.write(employeeDataList);
    }
    void readEmployeePayrollData(IOService ioService) throws IOException {
        PayrollService payrollService=getEmployeePayrollObject(ioService);
        payrollService.read();
    }
    public long countEntries(IOService ioService) throws IOException {
        PayrollService payrollService = getEmployeePayrollObject(ioService);
        return payrollService.countEntries();
    }

    private PayrollService getEmployeePayrollObject(IOService ioService) throws IOException {
        PayrollService payrollService = null;
        if(IOService.FILE_IO.equals(ioService)){
            payrollService = new FileIOServiceImpl();
        }
        else if(IOService.CONSOLE_IO.equals(ioService)){
            payrollService = new ConsoleIOServiceImpl();
        }
        return payrollService;
    }
}
