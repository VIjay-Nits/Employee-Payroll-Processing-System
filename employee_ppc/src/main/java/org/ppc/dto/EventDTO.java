package org.ppc.dto;

import lombok.*;
import org.ppc.entities.Event;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO  implements Serializable {
        private int id;
        private String empId;
        private String firstName;
        private String lastName;
        private String designation;
        private String event;
        private String value;
        private String eventDate;
        private String note;

        public Event getEventObj(){
                if(this.event.equals("ONBOARD"))return new Event(1,"ONBOARD",null);
                else if(this.event.equals("SALARY"))return new Event(2,"SALARY",null);
                else if(this.event.equals("BOUNS"))return new Event(3,"BOUNS",null);
                else if(this.event.equals("EXIT"))return new Event(4,"EXIT",null);
                else if(this.event.equals("REIMBURSEMENT"))return new Event(5,"REIMBURSEMENT",null);
                else return null;
        }
}
