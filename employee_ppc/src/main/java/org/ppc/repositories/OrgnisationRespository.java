package org.ppc.repositories;

import org.ppc.entities.Orgnisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrgnisationRespository extends JpaRepository<Orgnisation,Integer> {

    Optional<Orgnisation> findByOrgName(String orgName);
}
