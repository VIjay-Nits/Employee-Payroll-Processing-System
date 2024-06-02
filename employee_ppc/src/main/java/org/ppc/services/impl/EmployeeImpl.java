package org.ppc.services.impl;

import org.ppc.dto.EmployeeAmountDTO;
import org.ppc.dto.EmployeeFinancialReportDTO;
import org.ppc.dto.FinancailEventReportDTO;
import org.ppc.dto.OnboardExitInfo;
import org.ppc.entities.Employee;
import org.ppc.entities.Orgnisation;
import org.ppc.repositories.EmployeeRepository;
import org.ppc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class EmployeeImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<OnboardExitInfo> onboardExitInfoList(int orgID) {
        List<Map<String,Object>> ans = employeeRepository.monthlyOnboardExitData(orgID);
        List<OnboardExitInfo> onboardExitInfoList = new ArrayList<>();
        for(Map<String,Object> map:ans){
            OnboardExitInfo obj = new OnboardExitInfo();

            obj.setEmpID((Integer) map.get("eid"));
            obj.setEventName((String)map.get("evName"));
            obj.setYearMonth(map.get("month"));
            onboardExitInfoList.add(obj);
        }

        return onboardExitInfoList;
    }

    @Override
    public Optional<Employee> getEmployeeByEmpId(String empID) {
        return employeeRepository.findByEmpID(empID);
    }



    @Override
    @Transactional(readOnly = false)
    public Employee add(String empId, String firstName, String lastName, String designation, Orgnisation org) {
        Employee e = new Employee();
        e.setEmpID(empId);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setDesignation(designation);
        e.setOrgnisation(org);
        return employeeRepository.saveAndFlush(e);

    }

    @Override
    public List<EmployeeAmountDTO> monthlySalaryList(int orgID) {
        List<Map<String,Object>> ans = employeeRepository.monthlySalaryReport(orgID);
        List<EmployeeAmountDTO> monthlySalaryList = new ArrayList<>();
        for(Map<String,Object> map:ans){
            EmployeeAmountDTO obj = new EmployeeAmountDTO();

            obj.setMonth(map.get("month"));
            obj.setTotalAmountPaid(Double.parseDouble((String.valueOf(map.get("totalsalary")))));
            obj.setTotalEmployee(Double.parseDouble(String.valueOf(map.get("totaleml"))));
            monthlySalaryList.add(obj);
        }

        return monthlySalaryList;

    }

    @Override
    public List<EmployeeFinancialReportDTO> employeeTotalEarningList(int orgID) {

        List<Map<String,Object>> ans = employeeRepository.employeeFinancialReport(orgID);
        List<EmployeeFinancialReportDTO> employeeEarningList = new ArrayList<>();
        for(Map<String,Object> map:ans){
            EmployeeFinancialReportDTO obj = new EmployeeFinancialReportDTO();
            //map.forEach((k,v)-> System.out.println("K: "+k+" V: "+v));
            obj.setEmployeeId(String.valueOf(map.get("empID")));
            obj.setFirstName(String.valueOf(map.get("fname")));
            obj.setLastName(String.valueOf(map.get("lname")));
            obj.setTotalAmountPaid(Double.parseDouble(String.valueOf(map.get("sum"))));
            employeeEarningList.add(obj);
        }

        return employeeEarningList;

    }

    @Override
    public List<EmployeeAmountDTO> monthlyTotalAmountList(int orgID) {
        List<Map<String,Object>> ans = employeeRepository.monthlyTotalAmountReport(orgID);
        List<EmployeeAmountDTO> monthlyAmountList = new ArrayList<>();
        for(Map<String,Object> map:ans){
            EmployeeAmountDTO obj = new EmployeeAmountDTO();
            //map.forEach((k,v)-> System.out.println("K: "+k+" V: "+v));
            obj.setMonth(map.get("month"));
            obj.setTotalAmountPaid(Double.parseDouble((String.valueOf(map.get("amountsum")))));
            obj.setTotalEmployee(Double.parseDouble(String.valueOf(map.get("totalempl"))));
            monthlyAmountList.add(obj);
        }

        return monthlyAmountList;
    }

    @Override
    public List<FinancailEventReportDTO> eventList(int orgID) {
        List<Map<String,Object>> ans = employeeRepository.eventReportFinancial(orgID);
        List<FinancailEventReportDTO> eventReportList = new ArrayList<>();
        for(Map<String,Object> map:ans){
            FinancailEventReportDTO obj = new FinancailEventReportDTO();
            //map.forEach((k,v)-> System.out.println("K: "+k+" V: "+v));
            obj.setEventName(String.valueOf(map.get("event")));
            obj.setEmployeeId(String.valueOf(map.get("empID")));
            obj.setEventDate(map.get("eventDate"));
            obj.setEventValue(map.get("eventValue"));
            eventReportList.add(obj);
        }

        return eventReportList;
    }


}
