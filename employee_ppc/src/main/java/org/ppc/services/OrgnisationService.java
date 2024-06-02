package org.ppc.services;

import org.ppc.entities.Employee;
import org.ppc.entities.Orgnisation;

import java.util.List;
import java.util.Optional;

public interface OrgnisationService {

    public List<Employee> getAllEmployee(int id);

    public Orgnisation add(String name);

    Optional<Orgnisation> getOrgByName(String orgName);
}
