package org.ppc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OnboardExitInfo {

    private String eventName;
    private Object yearMonth;
    private Integer empID;

}
