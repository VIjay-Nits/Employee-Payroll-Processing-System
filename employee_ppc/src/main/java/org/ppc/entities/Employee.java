package org.ppc.entities;


import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "empID")
    private String empID;

    @Column(name = "empFName")
    private String firstName;

    @Column(name = "empLName")
    private String lastName;

    @Column(name = "designation")
    private String designation;

    @JoinColumn(name = "orgID",referencedColumnName = "orgID")
    @ManyToOne
    private Orgnisation orgnisation;

    @OneToMany(mappedBy = "emp",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EventEmployee> eventEmployeeList;

}
