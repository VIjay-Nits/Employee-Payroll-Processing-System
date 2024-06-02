package org.ppc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//4th
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeFinancialReportDTO  implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private Double totalAmountPaid;


}
