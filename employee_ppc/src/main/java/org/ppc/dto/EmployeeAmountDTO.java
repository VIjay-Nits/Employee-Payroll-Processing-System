package org.ppc.dto;

//3rd and 5th

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeAmountDTO  implements Serializable {

    private Object month;
    private Double totalAmountPaid;
    private Double totalEmployee;

}
