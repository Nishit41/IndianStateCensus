import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() throws IOException {
        EmployeeData employeeData1 = new EmployeeData (1,"Saurabh", 40000);
        EmployeeData  employeeData2 = new EmployeeData (2,"Sachin", 20000);
        EmployeeData  employeeData3 = new EmployeeData (3,"Vinay", 50000);

        List<EmployeeData > employeeDataList = new ArrayList<>();
        employeeDataList.add(employeeData1);
        employeeDataList.add(employeeData2);
        employeeDataList.add(employeeData3);
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeeDataList);
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        long count = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,count);
    }
}
