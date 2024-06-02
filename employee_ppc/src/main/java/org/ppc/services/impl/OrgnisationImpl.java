package org.ppc.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.ppc.entities.Employee;
import org.ppc.entities.Orgnisation;
import org.ppc.repositories.OrgnisationRespository;
import org.ppc.services.OrgnisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class OrgnisationImpl implements OrgnisationService {

    @Autowired
    OrgnisationRespository orgnisationRespository;

    @Override
    public List<Employee> getAllEmployee(int id) {
        Optional<Orgnisation> orgnisation = orgnisationRespository.findById(id);

        if (orgnisation.isEmpty()){
            log.error("Orgnisation not found for Id: "+ id);
            return null;
        }else {
            return orgnisation.get().getEmployeeList();
        }
    }

    @Override
    public Orgnisation add(String name) {
        Orgnisation orgnisation = new Orgnisation();
        orgnisation.setOrgName(name);

       return orgnisationRespository.save(orgnisation);

    }

    @Override
    public Optional<Orgnisation> getOrgByName(String orgName) {
        return orgnisationRespository.findByOrgName(orgName);
    }
}
