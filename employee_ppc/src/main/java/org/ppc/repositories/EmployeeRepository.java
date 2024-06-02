package org.ppc.repositories;

import org.ppc.dto.EmployeeAmountDTO;
import org.ppc.dto.EmployeeFinancialReportDTO;
import org.ppc.dto.FinancailEventReportDTO;
import org.ppc.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ppc.dto.OnboardExitInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select ev.eventName as evName ,date_format(STR_TO_DATE(empev.value, '%d-%m-%Y'),'%Y-%m') as month, e.id as eid from Employee as e " +
            "join EventEmployee as empev on e.id = empev.emp.id " +
            "join Event as ev on empev.event.id = ev.eventID " +
            "and ev.eventName in ('ONBOARD','EXIT') " +
            " where e.orgnisation.id = :orgId "+
            "ORDER BY ev.eventName ," +
            "date_format(STR_TO_DATE(empev.value, '%d-%m-%Y'),'%Y-%m')")
    public List<Map<String, Object>> monthlyOnboardExitData(@Param("orgId") int orgId);

    //3rd - monthly salary report of employees
   @Query(value = "select  date_format(empev.eventDate ,'%Y-%m') as month, sum(empev.value) as totalsalary,count(e.id) as totaleml from Employee as e " +
            "join EventEmployee as empev on e.id = empev.emp.id " +
            "join Event as ev on empev.event.id = ev.eventID " +
            "and ev.eventName in ('SALARY') " +
           " where e.orgnisation.id = :orgId "+
            "GROUP BY date_format(empev.eventDate ,'%Y-%m') ")
    public List<Map<String, Object>> monthlySalaryReport(@Param("orgId") int orgId);


    //4th total amount paid to each emmployee
    @Query(value = "select e.empID as empID,e.firstName as fname,e.lastName as lname,sum(empev.value) as sum from Employee as e " +
            "join EventEmployee as empev on e.id = empev.emp.id " +
            "join Event as ev on empev.event.id = ev.eventID " +
            "and ev.eventName in ('SALARY','BOUNS','REIMBURSEMENT') " +
            " where e.orgnisation.id = :orgId "+
            "GROUP BY e.empID ")
    public List<Map<String, Object>> employeeFinancialReport(@Param("orgId") int orgId);

    //5th - monthly total amount paid to employees
    @Query(value = "select  date_format(empev.eventDate ,'%Y-%m') as month, sum(empev.value) as amountsum,count(e.id) as totalempl from Employee as e " +
            "join EventEmployee as empev on e.id = empev.emp.id " +
            "join Event as ev on empev.event.id = ev.eventID " +
            "and ev.eventName in ('SALARY','BOUNS','REIMBURSEMENT') " +
            " where e.orgnisation.id = :orgId "+
            "GROUP BY date_format(empev.eventDate ,'%Y-%m') " )
    public List<Map<String, Object>> monthlyTotalAmountReport(@Param("orgId") int orgId);

    //6th event details
    @Query(value = "select ev.eventName as event,e.empID as empID,empev.eventDate as eventDate,empev.value as eventValue from Employee as e  " +
            "join EventEmployee as empev on e.id = empev.emp.id " +
            "join Event as ev on empev.event.id = ev.eventID " +
            " where e.orgnisation.id = :orgId "+
            "order by e.empID")
    public List<Map<String, Object>> eventReportFinancial(@Param("orgId") int orgId);


    Optional<Employee> findByEmpID(String empID);
}
