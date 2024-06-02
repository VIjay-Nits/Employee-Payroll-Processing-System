package org.ppc.services;

import org.ppc.dto.EmployeeAmountDTO;
import org.ppc.dto.EmployeeFinancialReportDTO;
import org.ppc.dto.FinancailEventReportDTO;
import org.ppc.dto.OnboardExitInfo;
import org.ppc.entities.Employee;
import org.ppc.entities.Orgnisation;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<OnboardExitInfo> onboardExitInfoList(int orgID);

    Optional<Employee> getEmployeeByEmpId(String empID);

    Employee add(String empId, String firstName, String lastName, String designation, Orgnisation org);
    //3rd
    List<EmployeeAmountDTO> monthlySalaryList(int orgID);
    //4th
    List<EmployeeFinancialReportDTO> employeeTotalEarningList(int orgID);
    //5th
    List<EmployeeAmountDTO> monthlyTotalAmountList(int orgID);
    //6th
    List<FinancailEventReportDTO> eventList(int orgID);

}
