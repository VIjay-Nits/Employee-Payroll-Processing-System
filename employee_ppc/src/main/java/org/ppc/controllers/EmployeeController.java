package org.ppc.controllers;


import org.ppc.dto.EmployeeAmountDTO;
import org.ppc.dto.EmployeeFinancialReportDTO;
import org.ppc.dto.FinancailEventReportDTO;
import org.ppc.dto.OnboardExitInfo;
import org.ppc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<OnboardExitInfo> getOnboardExitInfo(@RequestParam int orgID) {
        return employeeService.onboardExitInfoList(orgID);
    }

    //3rd - monthly salary report of employees
    @GetMapping("/monthlySalary")
    public List<EmployeeAmountDTO> getMonthlySalaryList(@RequestParam int orgID){
        return employeeService.monthlySalaryList(orgID);
    }

    //4th total amount paid to each emmployee
    @GetMapping("/earning")
    public List<EmployeeFinancialReportDTO> getEmployeeEarningList(@RequestParam int orgID){
        return employeeService.employeeTotalEarningList(orgID);
    }

    //5th - monthly total amount paid to employees
    @GetMapping("/monthlyTotalAmount")
    public List<EmployeeAmountDTO> getMonthlyAmountList(@RequestParam int orgID){
        System.out.println( orgID);
        return employeeService.monthlyTotalAmountList(orgID);
    }

    //6th event details
    @GetMapping("/eventDetails")
    public List<FinancailEventReportDTO> getEventDetailsInfo(@RequestParam int orgID){
        return employeeService.eventList(orgID);
    }

}

