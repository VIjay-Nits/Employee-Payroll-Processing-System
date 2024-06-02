package org.ppc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

//6th
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinancailEventReportDTO  implements Serializable {

    private String eventName;
    private String employeeId;
    private Object eventDate;
    private Object eventValue;

}
