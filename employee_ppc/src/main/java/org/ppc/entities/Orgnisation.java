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
@Table(name = "orgnisation")
public class Orgnisation {

    @Id
    @Column(name = "orgID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orgID;

    @Column(name = "name")
    private String orgName;

    @OneToMany(mappedBy = "orgnisation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}
