import java.io.IOException;
import java.util.List;

public interface PayrollService {
    void read();

    boolean write(List<EmployeeData> employeePayrollDataList) throws IOException;

    long countEntries() throws IOException;
}
