package org.ppc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp_event")
public class EventEmployee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "empID",referencedColumnName = "id")
    @ManyToOne
    private Employee emp;

    @JoinColumn(name = "eventID",referencedColumnName = "eventID")
    @ManyToOne
    private Event event;

    @Column(name = "date")
    private Date eventDate;

    @Column(name = "note" )
    private String eventNote;

    @Column(name = "value")
    private String value;


}
